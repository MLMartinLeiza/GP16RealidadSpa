/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Instalacion {
    private int CodInstall;
    private String nombre;
    private String DetalleDeUso;
    private double precio30m;
    public boolean estado;

    public Instalacion(int CodInstall, String nombre, String DetalleDeUso, double precio30m, double estado) {
        this.CodInstall = CodInstall;
        this.nombre = nombre;
        this.DetalleDeUso = DetalleDeUso;
        this.precio30m = precio30m;
    }

    public int getCodInstall() {
        return CodInstall;
    }

    public void setCodInstall(int codInstall) {
        this.CodInstall = codInstall;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }
    public String getDetalleDeUso() {
        return DetalleDeUso;
    }

    public void setDetalleDeUso(String DetalleDeUso) {
        this.DetalleDeUso = DetalleDeUso;
    }

    public double getPrecio30m() {
        return precio30m;
    }

    public void setPrecio30m(double precio30m) {
        this.precio30m = precio30m;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }



    @Override
    public String toString() {
        return "Intalacion{" + "codInstall=" + CodInstall + ", nombre=" + nombre + ", DetalleDeUso=" + DetalleDeUso + ", precio30m=" + precio30m + ", estado=" + estado + '}';
    }

    }

    
    
    
