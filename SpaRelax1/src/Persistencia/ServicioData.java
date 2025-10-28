/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Servicio;
import java.sql.Connection;


public class ServicioData {
    
    private Connection con = null;

  
    public ServicioData() {
        con = Conexion.getConexion();
    }

    Servicio buscarServicio(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
