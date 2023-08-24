package model.dao;

import model.Articulo;
import util.DBConnectionUtil;

import javax.persistence.Query;
import javax.persistence.RollbackException;
import java.util.ArrayList;


public class ArticuloDAO implements DAO<Articulo> {


    @Override
    public Articulo get(String codigo) {
        Articulo articulo = DBConnectionUtil.em.find(Articulo.class, codigo);

        if (articulo == null) {
            System.out.println("No existe un articulo con este codigo");

        }
        return articulo;
    }

    @Override
    public ArrayList<Articulo> getAll() {
        Query query = DBConnectionUtil.em.createQuery("SELECT a FROM Articulo a");
        return (ArrayList<Articulo>) query.getResultList();
    }



    @Override
    public void save(Articulo articulo) {
        try {
            DBConnectionUtil.em.getTransaction().begin();
            DBConnectionUtil.em.persist(articulo);
            DBConnectionUtil.em.getTransaction().commit();
            System.out.println("Articulo añadido!");
        } catch (RollbackException r) {
            System.out.println("Ya existe un articulo con este codigo!");
        }

    }

    @Override
    public void update(Articulo articulo) {

        try {
            DBConnectionUtil.em.getTransaction().begin();

            Articulo articuloPersisted = DBConnectionUtil.em.find(Articulo.class, articulo.getCodigo());
            if (articuloPersisted == null) {
                System.out.println("No existe un articulo con este codigo");

            } else {
                articuloPersisted.setDescripcion(articulo.getDescripcion());
                articuloPersisted.setPrecio(articulo.getPrecio());
                articuloPersisted.setGastosDeEnvio(articulo.getGastosDeEnvio());
                articuloPersisted.setTiempoDePreparacion(articulo.getTiempoDePreparacion());
                DBConnectionUtil.em.getTransaction().commit();
                System.out.println("Articulo actualizado!");
            }

        } catch (RollbackException r) {
            System.out.println(r.getMessage());
        }

    }

    @Override
    public void delete(String codigo) {
        try {
            DBConnectionUtil.em.getTransaction().begin();
            Articulo articuloDelete = DBConnectionUtil.em.find(Articulo.class, codigo);

            if (articuloDelete == null) {
                System.out.println("No existe un articulo con este codigo");

            } else {
                DBConnectionUtil.em.remove(articuloDelete);
                DBConnectionUtil.em.getTransaction().commit();
                System.out.println("Articulo borrado!");
            }

        } catch (RollbackException r) {
            System.out.println(r.getMessage());
        }


    }
}

