package it.vigorelli;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerBean {
    public static EntityManagerFactory managerFactory;
    public static EntityManager getEntityManager(){
        if(managerFactory == null)
            managerFactory = Persistence.createEntityManagerFactory("travelAgencyPersistenceUnit");
        return managerFactory.createEntityManager();
    }
}
