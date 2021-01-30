package Employees.db;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conn = null;
    private static String login = "roberdb";
    private static String password = "roberdb";
    private static String url = "jdbc:oracle:thin:@localhost:49161:xe";

    public static Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,login,password);
            conn.setAutoCommit(false);
            System.out.println((conn != null) ? "Conexion Exitosa" : "Conexion Erronea" );

        } catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,("Conexion Fallida " + e.getMessage()));
        }
        return conn;
    }

    public void desconexion() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.getConnection();
    }

}
