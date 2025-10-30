/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Cliente;
import Modelo.Tratamiento;

public class TestConexion {

    public static void main(String[] args) {
        Conexion.getConexion();
        ClienteData clienteD = new ClienteData();
        TratamientoData tratData = new TratamientoData();

        /*Pruebo cargar cliente a la base de datos
        Cliente cliente = new Cliente(38749542, "Martin Leiza", "0000393426", 30, "Nada", true);       
        clienteD.insertarCliente(cliente); 
        
         //Pruebo actualizar cliente
        Cliente cliente = new Cliente(1, 38749730, "Martin Leiza", "0000393426", 30, "Nada de nada", true);   
        clienteD.actualizarCliente(cliente); 
        
         //Pruebo buscarCliente
        System.out.println(clienteD.buscarCliente("Martin Leiza")); */
 /*Insertar un cliente
        Cliente cliente = new Cliente(44020403, "Gomez Santiago", "266346734", 24, "Sin afecciones", true);
        clienteD.insertarCliente(cliente);

        // Buscar cliente por nombre
        System.out.println(clienteD.buscarCliente("Gomez Santiago"));

        // Mostrar integrantes
        System.out.println("\nIntegrantes del grupo:");
        System.out.println("1. Martin Leiza");
        System.out.println("2. [Compañero 2]");
        System.out.println("3. [Compañero 3]");   */
 /* Insertar un cliente
       Cliente cliente = new Cliente(40523484, "Eduardo Gimenes", "53982367", 35, "Sin afecciones", true);
        clienteD.insertarCliente(cliente);

        // Buscar cliente por nombre
        System.out.println(clienteD.buscarCliente("Eduardo Gimenes"));

        // Mostrar integrantes
        System.out.println("\nIntegrantes del grupo:");
        System.out.println("1. Martin Leiza");
        System.out.println("2. Gomez Santiago");
        System.out.println("3. Eduardo Gimenes"); 
        System.out.println("4. "); */
 /* Cliente cliente = new Cliente(45886532, "Milagros Alfaro", "53982367", 21, "Sin afecciones", true);
        clienteD.insertarCliente(cliente);

        // Buscar cliente por nombre
        System.out.println(clienteD.buscarCliente("Milagros Alfaro"));

        // Mostrar integrantes
        System.out.println("\nIntegrantes del grupo:");
        System.out.println("1. Martin Leiza");
        System.out.println("2. Gomez Santiago");
        System.out.println("3. Eduardo Gimenes"); 
        System.out.println("4. Milagros Alfaro");  */
        // Cargar tratamiento
        /*Tratamiento nuevoTratam = new Tratamiento(2, "Masaje de tejido profundo", "Para aliviar tensión muscular crónica y tratar contracturas, con presión más intensa", 30, 5000, true);
        
        tratData.actualizarTratamiento(nuevoTratam);*/
        /*System.out.println(tratData.buscarTratamiento("Masaje Sueco"));*/
        
        
    }
}
