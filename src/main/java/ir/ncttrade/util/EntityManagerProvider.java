package ir.ncttrade.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jdbc-postgres");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
