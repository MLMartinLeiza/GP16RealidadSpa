/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;


public class ServicioData {
    
    private Connection con = null;

  
    public ServicioData() {
        con = Conexion.getConexion();
    }
    
}
