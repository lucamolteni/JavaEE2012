package it.vigorelli;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerBean {
    static EntityManagerFactory managerFactory;

    public static EntityManager getEntityManager() {
        if(managerFactory == null) {
            managerFactory = Persistence.createEntityManagerFactory("05persistenceUnit");
        }
        return managerFactory.createEntityManager();
    }
}