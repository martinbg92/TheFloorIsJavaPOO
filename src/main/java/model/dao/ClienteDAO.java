package model.dao;

import model.Cliente;
import util.DBConnectionUtil;

import javax.persistence.Query;
import javax.persistence.RollbackException;
import java.util.ArrayList;


public class ClienteDAO implements DAO<Cliente> {


    @Override
    public Cliente get(String email) {
        Cliente cliente = DBConnectionUtil.em.find(Cliente.class, email);

        if (cliente == null) {
            System.out.println("No existe un cliente con este email");

        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> getAll() {
        Query query = DBConnectionUtil.em.createQuery("SELECT a FROM Cliente a");
        return (ArrayList<Cliente>) query.getResultList();
    }


    public ArrayList<Cliente> getClientesEstandar() {
        Query query = DBConnectionUtil.em.createQuery("SELECT a FROM Cliente a WHERE a.is_premium = 0");

        return (ArrayList<Cliente>) query.getResultList();
    }

    public ArrayList<Cliente> getClientesPremium() {
        Query query = DBConnectionUtil.em.createQuery("SELECT a FROM Cliente a WHERE a.is_premium = 1");

        return (ArrayList<Cliente>) query.getResultList();
    }

    @Override
    public void save(Cliente cliente) {
        try {
            DBConnectionUtil.em.getTransaction().begin();
            DBConnectionUtil.em.persist(cliente);
            DBConnectionUtil.em.getTransaction().commit();
            System.out.println("Cliente añadido!");
        } catch (RollbackException r) {
            System.out.println("Ya existe un cliente con este email!");
        }
    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(String id) {

    }
}
