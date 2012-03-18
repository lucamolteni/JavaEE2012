package it.vigorelli;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final TypedQuery<Orders> query = em.createQuery("select o from Orders o", Orders.class);
        final List<Orders> list = query.getResultList();
        for(Orders b : list) {
            System.out.println(b);
        }
    }
}
