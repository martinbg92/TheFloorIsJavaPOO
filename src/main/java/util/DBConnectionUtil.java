package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnectionUtil {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("online_store");
    public static final EntityManager em = emf.createEntityManager();


}


