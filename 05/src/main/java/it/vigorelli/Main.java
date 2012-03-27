package it.vigorelli;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.AbstractCollection;

public class Main {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        final Publisher p1 = new Publisher("Il mio publisher", "il mio indirizzo");
        em.persist(p1);

        tx.commit();
        em.close();
    }

    private static void method2() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();
        final Publisher p1 = new Publisher("Il mio publisher", "il mio indirizzo");
        tx.commit();
        em.persist(p1);

        tx.begin();
        final Publisher p2 = new Publisher("Il mio publisher2 ", "il mio indirizzo2 ");
        em.persist(p2);
        tx.commit();
        em.close();
    }

    private static void method3() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        final Publisher p1 = new Publisher("Il mio publisher ha due libri", "Via dei due libri");
        final Book b1 = new Book("Il mio libro", 23l, "Luca Molteni");
        final Book b2 = new Book("Il mio libro 2 ", 30l, "Luca Molteni");

        em.persist(p1);
        p1.getBook().add(b1);
        p1.getBook().add(b2);

        tx.commit();
        em.close();
    }

    private static void method4() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        final Publisher p1 = new Publisher("Il mio publisher ha tre libri", "Via dei tre libri");
        final Book b1 = new Book("Il mio libro", 23l, "Luca Molteni");
        final Book b2 = new Book("Il mio libro 2 ", 30l, "Luca Molteni");

        em.persist(p1);
        p1.addBook(b1);
        p1.addBook(b2);

        tx.commit();
        em.close();
    }

    private static void method5() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        final Publisher p1 = new Publisher("Il mio publisher ha tre libri", "Via dei tre libri");
        final Book b1 = new Book("Il mio libro", 23l, "Luca Molteni");
        final Book b2 = new Book("Il mio libro 2 ", 30l, "Luca Molteni");


        // Senza cascade si deve persistere anche ogni Book, ma si può fare anche prima dell'aggiungerlo al publisher
        em.persist(p1);

        em.persist(b1);
        em.persist(b2);

        p1.addBook(b1);
        p1.addBook(b2);

        tx.commit();
        em.close();
    }

    private static void method6() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        final Publisher p1 = new Publisher("Il mio publisher ha tre libri", "Via dei tre libri");
        final Book b1 = new Book("Il mio libro", 23l, "Luca Molteni");
        final Book b2 = new Book("Il mio libro 2 ", 30l, "Luca Molteni");

        em.persist(p1);

        em.persist(b1);
        em.persist(b2);

        // Lo trova senza eseguire la query perché è nella cache del Persistence Context
        final Book b3 = em.find(Book.class, b1.getIsbn());

        p1.addBook(b1);
        p1.addBook(b2);

        tx.commit();
        em.close();
    }

    private static void method7() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        final Publisher p1 = new Publisher("Il mio publisher ha tre libri", "Via dei tre libri");
        final Book b1 = new Book("Questo sarà rimosso", 23l, "Luca Molteni");
        final Book b2 = new Book("Questo resterà ", 30l, "Luca Molteni");

        p1.addBook(b1);
        p1.addBook(b2);

        em.persist(p1);

        em.persist(b1);
        em.persist(b2);

        final Book b3 = em.find(Book.class, b1.getIsbn());
        em.remove(b3);

        tx.commit();
        em.close();
    }

    private static void method8() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        final Publisher p1 = new Publisher("Nessuno di questi libri", "Via dei tre libri");
        final Book b1 = new Book("Rimarrà sul ", 23l, "Luca Molteni");
        final Book b2 = new Book("Database col cascade ", 30l, "Luca Molteni");

        p1.addBook(b1);
        p1.addBook(b2);

        em.persist(p1);

        em.remove(p1);
        tx.commit();
        em.close();
    }


    private static void method9() {
        final EntityManager em = EntityManagerBean.getEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        final Publisher p1 = new Publisher("Publisher Detached", "Via dei tre libri");
        em.persist(p1);
        tx.commit();
        em.close();


        final EntityManager em2 = EntityManagerBean.getEntityManager();
        final EntityTransaction tx2 = em2.getTransaction();
        tx2.begin();

        final Book b1 = new Book("Libro1", 23l, "Luca Molteni");
        final Book b2 = new Book("Libro2", 30l, "Luca Molteni");
        p1.addBook(b1);
        p1.addBook(b2);

        final Publisher merged = em2.merge(p1);
        p1.setName("p1 è ancora detached"); // Questa update non viene eseguita
        merged.setName("Ora il publisher non è più detached");

        tx2.commit();
        em2.close();
    }

}
