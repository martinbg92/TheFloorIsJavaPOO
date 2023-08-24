package controller.old;

import model.Articulo;
import model.Cliente;
import model.Pedido;
import model.dao.DAOFactory;
import view.old.PedidoView;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ControladorPedido {
    private static DAOFactory factory = new DAOFactory();

    public static void addPedido() {

        String emailCliente = PedidoView.pedirClientePedido();
        Cliente cliente = factory.getClienteDAO().get(emailCliente);
        if (cliente == null) {
            PedidoView.mostrarMensaje("El cliente no existe!");
            return;
        }

        String codigoArticulo = PedidoView.pedirArticuloPedido();
        Articulo articulo = factory.getArticuloDAO().get(codigoArticulo);

        if (articulo.getCodigo() == null) {
            PedidoView.mostrarMensaje("El articulo no existe!");
            return;
        }

        int cantidad = PedidoView.pedirCantidad();

        factory.getPedidoDAO().save(new Pedido(cliente, articulo, cantidad));
    }

    public static void mostrarPedidosEnviados() {
        ArrayList<Pedido> lista = factory.getPedidoDAO().getAll();

        for (Pedido pedido : lista) {
            if (pedido.getEnviado() == 1) {
                PedidoView.printPedido(pedido);
                System.out.println();
            }
        }
    }

    public static void mostrarPedidosNoEnviados() {
        ArrayList<Pedido> lista = factory.getPedidoDAO().getAll();

        for (Pedido pedido : lista) {
            if (pedido.getEnviado() == 0) {
                PedidoView.printPedido(pedido);
                System.out.println();
            }
        }
    }


    public static void deletePedido() {

        int numeroPedido = PedidoView.pedirNumeroPedido();
        String str = String.valueOf(numeroPedido);
        Pedido pedido = factory.getPedidoDAO().get(str);

        if (pedido.getCliente() == null) {
            System.out.printf("\nPedido con numero %d no existe!",numeroPedido);
        } else if (LocalDateTime.now().isAfter(pedido.getFechaYHoraDelPedido().plusMinutes(pedido.getArticulo().getTiempoDePreparacion()))  || pedido.getEnviado() ==1){
            System.out.printf("\nPedido con numero %d ya ha sido enviado!",numeroPedido);
        }else {
            factory.getPedidoDAO().delete(str);
            System.out.printf("\nPedido con numero %d se ha borrado!",numeroPedido);
        }

    }

}
