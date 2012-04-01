package it.vigorelli;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.AbstractCollection;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        setUp();
        
        final EntityManager em = EntityManagerBean.getEntityManager();
        
        final TypedQuery<User> q1 = em.createQuery(
                "select u from User u"
                , User.class);
        printQueryResult(q1, "Tutti gli utenti");

        final TypedQuery<Book> q2 = em.createQuery(
                "select b " +
                "from Book b " +
                "where b.author = 'Gavin King'"
                , Book.class);
        printQueryResult(q2, "Tutti i libri di Gavin King");

        final TypedQuery<Purchase> q3 = em.createQuery(
                "select p " +
                "from Purchase p " +
                "where p.book.bookName = 'The C Programming Language'"
                , Purchase.class);
        printQueryResult(q3, "Tutte gli acquisti del C Programming language");

        final TypedQuery<User> q4 = em.createQuery(
                "select p.user " +
                "from Purchase p " +
                "where p.book.bookName like 'The C Programming%'"
                , User.class);
        printQueryResult(q4, "Tutte le persone che hanno acquistato C Programming language ");

        final TypedQuery<Publisher> q5 = em.createQuery(
                "select p " +
                "from Publisher p " +
                "left join p.book b " +
                "left join b.purchasedUser purch " +
                "where purch.discount > 15 "
                , Publisher.class);
        printQueryResult(q5, "Tutte i Publisher che hanno effettuato uno sconto > 15 ");

        final TypedQuery<Object[]> q6 = em.createQuery(
                "select p, count(purch) " +
                "from Publisher p " +
                "left join p.book b " +
                "left join b.purchasedUser purch " +
                "where purch.discount > 5 "
                , Object[].class);
        System.out.println("Tutte i Publisher con quanti acquisti hanno fatto  ");
        for(Object[] o : q6.getResultList()) {
            System.out.println(o[0] + ":" + o[1]);
        }

        final TypedQuery<Map> q7 = em.createQuery(
                "select new map (p as pub, avg(purch.discount) as av) " +
                "from Publisher p " +
                "left join p.book b " +
                "left join b.purchasedUser purch "
                , Map.class);
        System.out.println("Tutte i Publisher con la media degli sconti ");
        for(Map o : q7.getResultList()) {
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
