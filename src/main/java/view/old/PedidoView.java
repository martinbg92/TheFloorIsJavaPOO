package view.old;



import model.Pedido;
import util.ViewUtil;

import java.util.Scanner;

public class PedidoView {
    static Scanner teclado = new Scanner(System.in);

    public static String pedirClientePedido(){
        System.out.println("\nIntroduce el email del cliente:");
        return teclado.nextLine();
    }

    public static String pedirArticuloPedido() {
        System.out.println("\nIntroduce el código del articulo:");
        return teclado.nextLine();
    }

    public static void printPedido(Pedido pedido) {
        System.out.println("Numero de pedido: "+pedido.getNumeroDePedido());
        System.out.println("Email Cliente: "+pedido.getCliente().getEmail());
        System.out.println("Articulo: "+ pedido.getArticulo().getDescripcion());
        System.out.println("Cantidad: "+pedido.getCantidad());
        System.out.println("Realizado en: "+pedido.getFechaYHoraDelPedido());
        System.out.println("Enviado: "+ ((pedido.getEnviado() ==1) ? "Si" : "No"));
    }


    public static void mostrarMensaje(String s) {
        System.out.println(s);
    }

    public static int pedirCantidad() {
        System.out.println("\nIntroduce la cantidad:");
        return ViewUtil.pedirIntegerValido();
    }

    public static int pedirNumeroPedido() {
        System.out.println("\nIntroduce el numero de pedido:");
        return ViewUtil.pedirIntegerValido();
    }
}
