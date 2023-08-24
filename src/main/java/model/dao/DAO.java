package model.dao;

import java.util.ArrayList;

public interface DAO<T> {
    T get(String id);

    ArrayList<T> getAll();

    void save(T t);

    void update(T t);

    void delete(String id);

    
}