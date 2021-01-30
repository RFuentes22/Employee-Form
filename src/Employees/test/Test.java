/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employees.test;

import Employees.bo.EmpleadoBO;
import Employees.entities.Empleado;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rober
 */
public class Test {

    EmpleadoBO empBO = new EmpleadoBO();
    Empleado emp = new Empleado();
    String msg = "";

    public void insertar() throws SQLException {
        emp.setNombres("Rober");
        emp.setApellidos("Fuentes");
        emp.setCedula("123458");
        emp.setEstadoCivil('S');
        emp.setGenero('M');
        emp.setEdad(2);

        msg = empBO.agregarEmpleado(emp);
        System.out.println(msg);

    }

    public void modificar() throws SQLException {
        emp.setIdEmpleado(26);
        emp.setNombres("Antonio");
        emp.setApellidos("Fuentes");
        emp.setCedula("123458");
        emp.setEstadoCivil('S');
        emp.setGenero('M');
        emp.setEdad(2);

        msg = empBO.modificarEmpleado(emp);
        System.out.println(msg);

    }

    public void eliminar(int idEmp) throws SQLException {

        msg = empBO.eliminarEmpleado(idEmp);
        System.out.println(msg);

    }

    public static void main(String[] args) {
        Test test = new Test();
        try {
            //test.insertar();
            //test.modificar();
            test.eliminar(26);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
