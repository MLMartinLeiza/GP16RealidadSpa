package Modelo;

import java.time.LocalDateTime;

public class DiadeSpa {
    private int codPack;
    private LocalDateTime fechaHora;
    private String preferencias;
    private int codCli;
    private double monto;
    private boolean estado;

    public DiadeSpa() { }

    public DiadeSpa(int codPack, LocalDateTime fechaHora, String preferencias, int codCli, double monto, boolean estado) {
        this.codPack = codPack;
        this.fechaHora = fechaHora;
        this.preferencias = preferencias;
        this.codCli = codCli;
        this.monto = monto;
        this.estado = estado;
    }

    public DiadeSpa(LocalDateTime fechaHora, String preferencias, int codCli, double monto, boolean estado) {
        this.fechaHora = fechaHora;
        this.preferencias = preferencias;
        this.codCli = codCli;
        this.monto = monto;
        this.estado = estado;
    }

    public int getCodPack() { return codPack; }
    public void setCodPack(int codPack) { this.codPack = codPack; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getPreferencias() { return preferencias; }
    public void setPreferencias(String preferencias) { this.preferencias = preferencias; }

    public int getCodCli() { return codCli; }
    public void setCodCli(int codCli) { this.codCli = codCli; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "DiadeSpa{" +
                "codPack=" + codPack +
                ", fechaHora=" + fechaHora +
                ", preferencias='" + preferencias + '\'' +
                ", codCli=" + codCli +
                ", monto=" + monto +
                ", estado=" + estado +
                '}';
    }
}

