package Modelo;

public class Instalacion {

    private int codInstal;
    private String nombre;
    private String detalleUso;
    private double precio30m;
    private boolean estado;

    public Instalacion() {
    }

    public Instalacion(int codInstal, String nombre, String detalleUso, double precio30m, boolean estado) {
        this.codInstal = codInstal;
        this.nombre = nombre;
        this.detalleUso = detalleUso;
        this.precio30m = precio30m;
        this.estado = estado;
    }

    public Instalacion(String nombre, String detalleUso, double precio30m, boolean estado) {
        this.nombre = nombre;
        this.detalleUso = detalleUso;
        this.precio30m = precio30m;
        this.estado = estado;
    }

    public int getCodInstal() {
        return codInstal;
    }

    public void setCodInstal(int codInstal) {
        this.codInstal = codInstal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalleUso() {
        return detalleUso;
    }

    public void setDetalleUso(String detalleUso) {
        this.detalleUso = detalleUso;
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
        return "Instalacion{"
                + "codInstal=" + codInstal
                + ", nombre='" + nombre + '\''
                + ", detalleUso='" + detalleUso + '\''
                + ", precio30m=" + precio30m
                + ", estado=" + estado
                + '}';
    }
}
