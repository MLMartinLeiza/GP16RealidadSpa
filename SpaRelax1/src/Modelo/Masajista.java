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
    private String nombreApellido;
    private String telefono;
    private String especialidad;
    private boolean estado;

    public Masajista() {

    }

    public Masajista(String nombreApellido, String telefono, String especialidad, boolean estado) {
        this.nombreApellido = nombreApellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.estado = estado;
    }
    
    public Masajista(int matricula, String nombreApellido, String telefono, String especialidad, boolean estado) {
        this.matricula = matricula;
        this.nombreApellido = nombreApellido;
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

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
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
        return "Matrícula: " + matricula + " " + nombreApellido;
    }

}
