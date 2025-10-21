/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class ConsultorioData {
    
 private Connection con = null;

    public ConsultorioData() {
          con = Conexion.getConexion();
    }
 
 

    
    
}
