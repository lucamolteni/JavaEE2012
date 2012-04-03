package it.vigorelli;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        setUp();
        method1();
        method2();
        method3();
        method4();
        method5();
        method6();
        method7();
    }

    private static void method1() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<User> q = cb.createQuery(User.class);
        q.select(q.from(User.class));
        printQueryResult(em.createQuery(q), "Tutti gli utenti");
    }

    private static void method2() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Book> criteria = cb.createQuery(Book.class);
        final Root<Book> root = criteria.from(Book.class);
        criteria.select(root);
        criteria.where(cb.equal(root.get(Book_.author), "Gavin King"));
        printQueryResult(em.createQuery(criteria), "Tutti i libri di Gavin King");
    }

    private static void method3() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Purchase> criteria = cb.createQuery(Purchase.class);
        final Root<Purchase> root = criteria.from(Purchase.class);
        criteria.select(root);
        criteria.where(cb.equal(root.get(Purchase_.book).get(Book_.bookName), "The C Programming Language "));
        printQueryResult(em.createQuery(criteria), "Tutte gli acquisti del C Programming language");
    }

    private static void method4() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<User> criteria = cb.createQuery(User.class);
        final Root<Purchase> root = criteria.from(Purchase.class);
        criteria.select(root.get(Purchase_.user));
        criteria.where(cb.like(root.get(Purchase_.book).get(Book_.bookName), "The C Programming%"));
        printQueryResult(em.createQuery(criteria), "Tutte le persone che hanno acquistato C Programming language ");
    }

    private static void method5() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Publisher> criteria = cb.createQuery(Publisher.class);
        final Root<Publisher> root = criteria.from(Publisher.class);
        criteria.select(root);
        final Join<Publisher, Book> b = root.join(Publisher_.book);
        final Join<Book, Purchase> purch = b.join(Book_.purchasedUser);
        criteria.where(cb.greaterThan(purch.get(Purchase_.discount), 15l));
        printQueryResult(em.createQuery(criteria), "Tutte i Publisher che hanno effettuato uno sconto > 15 ");
    }

    private static void method6() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteria = cb.createTupleQuery();
        final Root<Publisher> root = criteria.from(Publisher.class);
        final Join<Publisher, Book> b = root.join(Publisher_.book);
        final Join<Book, Purchase> purch = b.join(Book_.purchasedUser);
        criteria.multiselect(root, cb.count(purch));
        System.out.println("Tutte i Publisher con quanti acquisti hanno fatto  ");
        for(Tuple o : em.createQuery(criteria).getResultList()) {
            System.out.println(o.get(0) + ":" + o.get(1));
        }
    }

    private static void method7() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteria = cb.createTupleQuery();
        final Root<Publisher> root = criteria.from(Publisher.class);
        final Join<Publisher, Book> b = root.join(Publisher_.book);
        final Join<Book, Purchase> purch = b.join(Book_.purchasedUser);
        criteria.multiselect(root.alias("pub"), cb.avg(purch.get(Purchase_.discount)).alias("av"));
        System.out.println("Tutte i Publisher con la media degli sconti ");
        for(Tuple o : em.createQuery(criteria).getResultList()) {
            System.out.println(o.get("pub") + ":" + o.get("av"));
        }
    }

    private static void setUp() {
        final User user1 = new User("Luca", "Molteni", "lmolteni", "luca.molteni@me.com");
        final User user2 = new User("User2", "Surname2", "account2", "username2@domain2.com");

        final Publisher p1 = new Publisher("All the cool CS books", "San Francisco CA");
        final Book b1 = new Book("Java Persistence With Hibernate", 23l, "Gavin King");
        final Book b2 = new Book("The C Programming Language ", 30l, "Brian Kerninghan");

        p1.addBook(b1);
        p1.addBook(b2);

        final Purchase purch1 = new Purchase(user1, b1, 10l);
        final Purchase purch2 = new Purchase(user1, b2, 20l);
        final Purchase purch3 = new Purchase(user2, b2, 15l);

        final EntityManager em = EntityManagerBean.getEntityManager();

        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(user1);
        em.persist(user2);
        em.persist(p1);
        em.persist(b1);
        em.persist(b2);
        em.persist(purch1);
        em.persist(purch2);
        em.persist(purch3);

        tx.commit();
        em.close();
    }
    
    private static void printQueryResult(TypedQuery q, String nomeQuery) {
        System.out.println("query = " + nomeQuery);
        for(Object o : q.getResultList()) {
            System.out.println(o);
        }
    }
}
