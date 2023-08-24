package model.dao;

import model.Pedido;
import util.DBConnectionUtil;

import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;


public class PedidoDAO implements DAO<Pedido>{

    @Override
    public Pedido get(String id) {

        Pedido pedido = DBConnectionUtil.em.find(Pedido.class, Integer.parseInt(id));

        if (pedido == null) {
            System.out.println("No existe un pedido con este id");

        }
        return pedido;
    }

    @Override
    public ArrayList<Pedido> getAll() {
        Query query = DBConnectionUtil.em.createQuery("SELECT a FROM Pedido a");
        return (ArrayList<Pedido>) query.getResultList();
    }


    public ArrayList<Pedido> getPedidosEnviados() {
        Query query = DBConnectionUtil.em.createQuery("SELECT a FROM Pedido a where a.enviado = 1");
        return (ArrayList<Pedido>) query.getResultList();
    }

    public ArrayList<Pedido> getPedidosPendientesDeEnvio() {
        Query query = DBConnectionUtil.em.createQuery("SELECT a FROM Pedido a where a.enviado = 0");
        return (ArrayList<Pedido>) query.getResultList();
    }
    @Override
    public void save(Pedido pedido) {
        try {
            DBConnectionUtil.em.getTransaction().begin();
            DBConnectionUtil.em.persist(pedido);
            StoredProcedureQuery query = DBConnectionUtil.em.createStoredProcedureQuery("set_time");
            query.execute();
            DBConnectionUtil.em.getTransaction().commit();
            System.out.println("Pedido añadido!");
        } catch (RollbackException r) {
            System.out.println("Ya existe un Pedido con este id!");
        }
    }

    @Override
    public void update(Pedido pedido) {

    }

    @Override
    public void delete(String id) {
        try {
            DBConnectionUtil.em.getTransaction().begin();
            Pedido pedidoDelete = DBConnectionUtil.em.find(Pedido.class, Integer.parseInt(id));

            if (pedidoDelete == null) {
                System.out.println("No existe un pedido con este id");

            } else {
                DBConnectionUtil.em.remove(pedidoDelete);
                DBConnectionUtil.em.getTransaction().commit();
                System.out.println("Pedido borrado!");
            }

        } catch (RollbackException r) {
            System.out.println(r.getMessage());
        }
    }
}
