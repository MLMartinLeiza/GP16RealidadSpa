package Modelo;

import java.time.LocalDateTime;
import java.util.List;

public class Sesion {
    private int codSesion;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Masajista masajista;
    private Servicio tratamiento; 
    private Consultorio consultorio;
    private boolean estado;

    
    public Sesion() {
    }

    public Sesion(int codSesion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin,
                  Masajista masajista, Servicio tratamiento, Consultorio consultorio, boolean estado) {
        this.codSesion = codSesion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.masajista = masajista;
        this.tratamiento = tratamiento;
        this.consultorio = consultorio;
        this.estado = estado;
    }

    public Sesion(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin,
                  Masajista masajista, Servicio tratamiento, Consultorio consultorio, boolean estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.masajista = masajista;
        this.tratamiento = tratamiento;
        this.consultorio = consultorio;
        this.estado = estado;
    }

   
    public int getCodSesion() {
        return codSesion;
    }

    public void setCodSesion(int codSesion) {
        this.codSesion = codSesion;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Masajista getMasajista() {
        return masajista;
    }

    public void setMasajista(Masajista masajista) {
        this.masajista = masajista;
    }

    public Servicio getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Servicio tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    @Override
    public String toString() {
        return "Sesion{" +
                "codSesion=" + codSesion +
                ", inicio=" + fechaHoraInicio +
                ", fin=" + fechaHoraFin +
                ", masajista=" + masajista +
                ", tratamiento=" + tratamiento +
                ", consultorio=" + consultorio +
                ", estado=" + estado +
                '}';
    }
}
