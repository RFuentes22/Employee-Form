/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employees.bo;

import Employees.dao.EmpleadoDAO;
import Employees.db.Conexion;
import Employees.entities.Empleado;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author rober
 */
public class EmpleadoBO {

    private String msg = " ";
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    public String agregarEmpleado(Empleado emp) throws SQLException{
        Connection conn = Conexion.getConnection();
        try {
            msg = empleadoDAO.agregarEmpleado(conn, emp);
            conn.commit();
            
        } catch (Exception e) {
            msg = msg + " " + e.getMessage();
            conn.rollback();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                msg = msg + " " + e.getMessage();
            }
        }
        return msg;
    }

    public String modificarEmpleado(Empleado emp) throws SQLException{
        Connection conn = Conexion.getConnection();
        try {
            msg = empleadoDAO.modificarEmpleado(conn, emp);
            conn.commit();
        } catch (Exception e) {
            msg = msg + " " + e.getMessage();
            conn.rollback();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                msg = msg + " " + e.getMessage();
            }
        }
        return msg;
    }

    public String eliminarEmpleado(int idEmp) throws SQLException{
        Connection conn = Conexion.getConnection();
        try {
            msg = empleadoDAO.eliminarEmpleado(conn, idEmp);
            conn.commit();
        } catch (Exception e) {
            msg = msg + " " + e.getMessage();
            conn.rollback();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                msg = msg + " " + e.getMessage();
            }
        }
        return msg;
    }

    public void listarEmpleado(JTable tabla) {
        Connection conn = Conexion.getConnection();
        empleadoDAO.listarEmpleado(conn, tabla);
        
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID(){
        Connection conn = Conexion.getConnection();
        int id = empleadoDAO.getMaxID(conn);
        
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return id;
    }
}
