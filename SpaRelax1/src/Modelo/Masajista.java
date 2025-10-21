/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Santy
 */
public class Masajista {
    
    private int idMasajista;
    private String nombre;
    private String apellido;
    private String telefono;
    private String especialidad;
    private boolean estado;
    
    public Masajista(){
        
    }
        public Masajista(String nombre, String apellido, String telefono, String especialidad, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.estado = estado;
        }
    public int getIdMasajista() {
        return idMasajista;
    }

    public void setIdMasajista(int idMasajista) {
        this.idMasajista = idMasajista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
            
       @Override
    public String toString() {
        return nombre + " " + apellido + " (" + especialidad + ")";
    }
}
