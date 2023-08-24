package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "articulos")
public class Articulo {
    @Id
    @Column(name ="codigo")
    private String codigo;

    @Column(name ="descripcion", nullable = false)

    private String descripcion;
    @Column(name ="precio" , nullable = false)
    private double precio;
    @Column(name ="gastos_de_envio" , nullable = false)
    private double gastosDeEnvio;
    @Column(name ="tiempo_de_preparacion" , nullable = false)
    private int tiempoDePreparacion;

    public Articulo() {
    }

    public Articulo(String codigo, String descripcion, double precio, double gastosDeEnvio, int tiempoDePreparacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.gastosDeEnvio = gastosDeEnvio;
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getGastosDeEnvio() {
        return gastosDeEnvio;
    }

    public void setGastosDeEnvio(double gastosDeEnvio) {
        this.gastosDeEnvio = gastosDeEnvio;
    }

    public int getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(int tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", gastosDeEnvio=" + gastosDeEnvio +
                ", tiempoDePreparacion=" + tiempoDePreparacion +
                '}';
    }
}
