/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
  
    private static final String URL = "jdbc:mariadb://localhost:3306/spa_relax1"; 
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    private static Connection conexion;

    private Conexion() {}

    public static Connection getConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Conexión exitosa a la base de datos");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("❌ Error al conectar: " + e.getMessage());
            }
        }
        return conexion;
    }
}
    

