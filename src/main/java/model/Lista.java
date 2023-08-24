package model;

import java.util.ArrayList;

public class Lista<T> {
    protected ArrayList<T> lista;


    public Lista() {
        this.lista = new ArrayList<T>();
    }

    public ArrayList<T> getLista() {
        return lista;
    }

    public void List(ArrayList<T> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "lista=" + lista +
                '}';
    }
}
