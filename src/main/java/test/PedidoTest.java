package test;

import model.Articulo;
import model.Cliente;
import model.Pedido;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PedidoTest {

    @Test
    void precioEnvioClienteEstandar() {
        Cliente cliente1 = new Cliente("Paco Perez","Barcelona 3","A12345678","paco@gmail.com","119191910",0);
        Articulo articulo1 = new Articulo("1","Aceite de Oliva",5,10,10);
        Pedido pedido1 = new Pedido(1,cliente1,articulo1,10, LocalDateTime.now());

        /* El cliente es Estandar asi qie no se le aplica ningun descuento*/
        assertEquals(pedido1.precioEnvio(), 10);
    }

    @Test
    void precioEnvioClientePremium() {
        Cliente cliente1 = new Cliente("Paco Perez","Barcelona 3","A12345678","paco@gmail.com","119191910",1,30,20);
        Articulo articulo1 = new Articulo("1","Aceite de Oliva",5,10,10);
        Pedido pedido1 = new Pedido(1,cliente1,articulo1,10, LocalDateTime.now());

        /* El cliente es Estandar asi qie no se le aplica ningun descuento*/
        assertEquals(pedido1.precioEnvio(), 8);
    }
}