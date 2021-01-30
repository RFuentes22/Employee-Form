/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employees.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Employees.entities.Empleado;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rober
 */
public class EmpleadoDAO {

    private String msg = " ";

    public String agregarEmpleado(Connection conn, Empleado emp) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO EMPLEADO (IDEMPLEADO,NOMBRES,APELLIDOS,CEDULA,ESTADO_CIVIL,GENERO,EDAD) VALUES (EMPLEADO_SEQ.NEXTVAL,?,?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, emp.getNombres());
            pst.setString(2, emp.getApellidos());
            pst.setString(3, emp.getCedula());
            pst.setString(4, emp.getEstadoCivil() + "");
            pst.setString(5, emp.getGenero() + "");
            pst.setInt(6, emp.getEdad());
            pst.execute();
            
            pst.close();
            msg = "Guardado Correctamente \n";

        } catch (Exception e) {
            msg = "No se pudo guardar correctamente \n" + e.getMessage();
        }
        return msg;
    }

    public String modificarEmpleado(Connection conn, Empleado emp) {
        PreparedStatement pst = null;
        String sql = "UPDATE EMPLEADO SET NOMBRES = ?, APELLIDOS = ?, CEDULA = ?, ESTADO_CIVIL = ?, GENERO = ?, EDAD = ?"
                + "WHERE IDEMPLEADO = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, emp.getNombres());
            pst.setString(2, emp.getApellidos());
            pst.setString(3, emp.getCedula());
            pst.setString(4, emp.getEstadoCivil() + "");
            pst.setString(5, emp.getGenero() + "");
            pst.setInt(6, emp.getEdad());
            pst.setInt(7, emp.getIdEmpleado());
            msg = "Modificado Correctamente \n";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            msg = "No se pudo modificar correctamente \n" + e.getMessage();
        }
        return msg;
    }

    public String eliminarEmpleado(Connection conn, int idEmp) {
        PreparedStatement pst = null, pst2 = null;
        String sql = "DELETE FROM EMPLEADO WHERE  IDEMPLEADO = ? ";
        String sqlRows = "SELECT COUNT(*) FROM EMPLEADO";

        try {
            pst2 = conn.prepareStatement(sqlRows);
            pst2.execute();

            System.out.println(pst2.executeQuery().getRow());
            pst2.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idEmp);

            msg = "Eliminado Correctamente \n";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            msg = "No se pudo eliminar correctamente \n" + e.getMessage();
        }
        return msg;
    }

    public void listarEmpleado(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRES", "APELLIDOS", "CEDULA", "ESTADO CIVIL", "GENERO", "EDAD"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM EMPLEADO ORDER BY IDEMPLEADO";
        String[] filas = new String[7];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    switch (i) {
                        case 4:
                            filas[i] = rs.getString(i + 1).equals("S") ? "Soltero" : "Casado";
                            break;
                        case 5:
                            filas[i] = rs.getString(i + 1).equals("M") ? "Masculino" : "Femenino";
                            break;
                        default:
                            filas[i] = rs.getString(i + 1);
                            //System.out.println(filas[i]);
                            break;
                    }
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar tabla");
        }

    }
    
    public int getMaxID(Connection conn){
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(IDEMPLEADO)+1 FROM EMPLEADO ORDER BY IDEMPLEADO";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar MaxID " + e.getMessage());
        }
        return id;
    }
}
