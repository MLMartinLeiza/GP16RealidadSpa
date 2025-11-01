package Modelo;

import java.time.LocalDateTime;

public class Sesion {

    private int codSesion;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Masajista masajista;
    private Tratamiento tratamiento;
    private Consultorio consultorio;
    private DiadeSpa diaDeSpa;
    private Instalacion instalacion;
    private boolean estado;

    public Sesion() {
    }

    public Sesion(int codSesion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin,
            Masajista masajista, Tratamiento tratamiento, Consultorio consultorio, DiadeSpa diaDeSpa, Instalacion instalacion, boolean estado) {
        this.codSesion = codSesion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.masajista = masajista;
        this.tratamiento = tratamiento;
        this.consultorio = consultorio;
        this.diaDeSpa = diaDeSpa;
        this.instalacion = instalacion;
        this.estado = estado;
    }

    public Sesion(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin,
            Masajista masajista, Tratamiento tratamiento, Consultorio consultorio, DiadeSpa diaDeSpa, Instalacion instalacion, boolean estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.masajista = masajista;
        this.tratamiento = tratamiento;
        this.consultorio = consultorio;
        this.diaDeSpa = diaDeSpa;
        this.instalacion = instalacion;
        this.estado = estado;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public DiadeSpa getDiaDeSpa() {
        return diaDeSpa;
    }

    public void setDiaDeSpa(DiadeSpa diaDeSpa) {
        this.diaDeSpa = diaDeSpa;
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

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
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
        return "Sesion{" + "codSesion=" + codSesion + ", fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin + ", masajista=" + masajista + ", tratamiento=" + tratamiento + ", consultorio=" + consultorio + ", diaDeSpa=" + diaDeSpa + ", instalacion=" + instalacion + ", estado=" + estado + '}';
    }

}
