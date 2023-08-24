package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido" )
    private int numeroDePedido;

    @JoinColumn(name = "cliente" , nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @JoinColumn(name = "articulo" , nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Articulo articulo;
    @Column(name = "cantidad" , nullable = false)
    private int cantidad;

    @Column(name = "realizado_en")
    private LocalDateTime fechaYHoraDelPedido;

    @Column(name = "enviado")
    private int enviado = 0;

    public Pedido() {
    }

    public Pedido(int numeroDePedido, Cliente cliente, Articulo articulo, int cantidad, LocalDateTime fechaYHoraDelPedido) {
        this.numeroDePedido = numeroDePedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fechaYHoraDelPedido = fechaYHoraDelPedido;
    }

    public Pedido( Cliente cliente, Articulo articulo, int cantidad, LocalDateTime fechaYHoraDelPedido) {

        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fechaYHoraDelPedido = fechaYHoraDelPedido;
    }

    public Pedido(Cliente cliente, Articulo articulo, int cantidad) {
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
    }



    public int getNumeroDePedido() {
        return numeroDePedido;
    }

    public void setNumeroDePedido(int numeroDePedido) {
        this.numeroDePedido = numeroDePedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaYHoraDelPedido() {
        return fechaYHoraDelPedido;
    }

    public String getFechaYHoraDelPedidoString() {
        return fechaYHoraDelPedido.toString();
    }
    public void setFechaYHoraDelPedido(LocalDateTime fechaYHoraDelPedido) {
        this.fechaYHoraDelPedido = fechaYHoraDelPedido;
    }

    public int getEnviado() {
        return enviado;
    }

    public void setEnviado(int enviado) {
        this.enviado = enviado;
    }

    public String getCodigoArticulo() {
        return this.articulo.getCodigo();
    }

    public String getEmailCliente() {
        return this.cliente.getEmail();
    }

    @Override
    public String toString() {
        return
                "\nNúmero de pedido: " + numeroDePedido +
                "\nFecha y hora del pedido: " + fechaYHoraDelPedido +
                "\nNIF: " + cliente.getNif() +
                "\nNombre del cliente: " + cliente.getNombre() +
                "\nCódigo articulo: " + articulo.getCodigo() +
                "\nDescripción del artículo: " + articulo.getDescripcion() +
                "\nCantidad: " + cantidad +
                "\nPrecio artículo: " + articulo.getPrecio() +
                "\nCoste envío: " + precioEnvio() +
                "\nPrecio total: " + calcularPrecioTotal() +
                "\nSe ha enviado: " + pedidoEnviado()
                ;
    }

    public String pedidoEnviado() {
        if (getEnviado() == 1){
            return "Pedido Enviado";
        }
        return "Pedido No Enviado";
    }

    public float precioEnvio() {
        if (this.cliente.tipoCliente() == "Cliente Premium"){
            return (float) ((this.articulo.getGastosDeEnvio()) * (1 - this.cliente.descuentoEnv() / 100));
        }
        return (float) (this.articulo.getGastosDeEnvio());
    }

    public double calcularPrecioTotal(){
        return precioEnvio() + (this.articulo.getPrecio() * this.cantidad);
    }


}
