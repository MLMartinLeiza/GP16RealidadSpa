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
    
    private int matricula;
    private String nombre_apellido;
    private String telefono;
    private String especialidad;
    private boolean estado;
    
    public Masajista(){
        
    }
        public Masajista(String nombre_apellido, String telefono, String especialidad, boolean estado) {
        this.nombre_apellido = nombre_apellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.estado = estado;
        }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
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
        return "Masajista{" + "matricula=" + matricula + ", nombre_apellido=" + nombre_apellido + ", telefono=" + telefono + ", especialidad=" + especialidad + ", estado=" + estado + '}';
    }      

    public int getIdMasajista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
