package it.vigorelli;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("01persistenceUnit");
        EntityManager em = emf.createEntityManager();
        final List test = em.createNativeQuery("select * from test").getResultList();
        for(Object lv : test) {
            Object[] valori = (Object[]) lv;
            System.out.printf("l = %s %s %n", valori[0], valori[1]);
        }
        System.out.println("Hello world");
    }
}
