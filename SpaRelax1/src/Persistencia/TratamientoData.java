package Persistencia;

import java.sql.Connection;

public class TratamientoData {
    private Connection con = null;
    
    public TratamientoData(){
        con = Conexion.getConexion();
    }
    
    // Mañana termino esta clase (Martin)
}
