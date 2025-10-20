/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Cliente;

public class TestConexion {

    public static void main(String[] args) {
        Conexion.getConexion();
        ClienteData clienteD = new ClienteData();

        /* Pruebo cargar cliente a la base de datos
        Cliente cliente = new Cliente(38749542, "Martin Leiza", "0000393426", 30, "Nada", true);       
        clienteD.insertarCliente(cliente); */
        
        /* Pruebo actualizar cliente
        Cliente cliente = new Cliente(1, 38749730, "Martin Leiza", "0000393426", 30, "Nada de nada", true);   
        clienteD.actualizarCliente(cliente); */
    }

}
