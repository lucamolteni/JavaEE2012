package it.vigorelli;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        final List<Book> list = query.getResultList();
        for(Book b : list) {
            System.out.println(b);
        }
    }
}
