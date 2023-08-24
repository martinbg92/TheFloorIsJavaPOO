package model.dao;

import model.Articulo;
import model.Cliente;
import model.Pedido;

public class DAOFactory {

    public DAO<Articulo> getArticuloDAO() {
        return new ArticuloDAO();
    }

    public DAO<Cliente> getClienteDAO() {
        return new ClienteDAO();
    }

    public DAO<Pedido> getPedidoDAO() {
        return new PedidoDAO();
    }



}
