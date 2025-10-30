/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author Usuario
*/
public class DiadeSpa {
    
     private int codPack;
    private String fechaHora;
    private String preferencias;
    private int CodCli;
    private double monto;
    private boolean estado;

    public DiadeSpa() {
    }

    public DiadeSpa(int codPack, String fechaHora, String preferencias, int CodCli, double monto, boolean estado) {
        this.codPack = codPack;
        this.fechaHora = fechaHora;
        this.preferencias = preferencias;
        this.CodCli = CodCli;
        this.monto = monto;
        this.estado = estado;
    }

    public DiadeSpa(String fechaHora, String preferencias, int CodCli, double monto, boolean estado) {
        this.fechaHora = fechaHora;
        this.preferencias = preferencias;
        this.CodCli = CodCli;
        this.monto = monto;
        this.estado = estado;
    }

    public int getCodPack() {
        return codPack;
    }

    public void setCodPack(int codPack) {
        this.codPack = codPack;
    }

    public String getfechaHora() {
         return fechaHora;
         
    }

    public void setfechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public int getCodCli() {
        return CodCli;
    }

    public void setCodCli(int CodCli) {
        this.CodCli = CodCli;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "DiadeSpa{" + "codPack=" + codPack + ", fechaHora=" + fechaHora + ", preferencias=" + preferencias + ", CodCli=" + CodCli + ", monto=" + monto + ", estado=" + estado + '}';
    }

 
    
    
    
}

