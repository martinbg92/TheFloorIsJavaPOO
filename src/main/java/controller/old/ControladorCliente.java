package controller.old;
import model.Cliente;
import model.dao.DAOFactory;
import view.old.ClienteView;

import java.util.ArrayList;


public class ControladorCliente {
    private static DAOFactory factory = new DAOFactory();

    public static void addCliente(Cliente cliente) {
        factory.getClienteDAO().save(cliente);

    }


    public static void mostrarTodosLosClientes() {
        ArrayList<Cliente> list = factory.getClienteDAO().getAll();

        for (Cliente cliente : list) {
            if (cliente.getIs_premium() == 0) {
                ClienteView.printClienteEstandar(cliente);
                System.out.println();
            } else if (cliente.getIs_premium() == 1) {
                ClienteView.printClientePremium(cliente);
                System.out.println();
            }
        }
    }

    public static void mostrarClientesEstandar() {
        ArrayList<Cliente> lista = factory.getClienteDAO().getAll();

        for (Cliente cliente : lista) {
            if (cliente.getIs_premium() == 0) {
                ClienteView.printClienteEstandar( cliente);
                System.out.println();
            }
        }
    }

    public static void mostrarClientesPremium() {
        ArrayList<Cliente> lista = factory.getClienteDAO().getAll();

        for (Cliente cliente : lista) {
            if (cliente.getIs_premium() == 1) {
                ClienteView.printClientePremium( cliente);
                System.out.println();
            }
        }
    }


}
