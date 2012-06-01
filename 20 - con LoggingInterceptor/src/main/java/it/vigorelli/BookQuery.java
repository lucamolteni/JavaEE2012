package it.vigorelli;

import org.hibernate.annotations.common.util.impl.LoggerFactory;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;
import javax.persistence.*;
import javax.transaction.Transaction;
import java.util.List;
import java.util.logging.Logger;

@Stateful
public class BookQuery {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager em;

    public List<Book> getAllBooks() {
        return em.createQuery("select b from Book b ", Book.class).getResultList();
    }

    public Book find(Long id) {
        return em.find(Book.class, id);
    }

    @Remove
    public void destroy() {
        Logger.getLogger(BookQuery.class.getSimpleName()).info("BookQuery Destroyed");
    }

    public void save(Book b) {
        final EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(b);
            payBook(b, tx);
            tx.commit();
        }   catch(PersistenceException e) {
            tx.rollback();
        }
    }

    private void payBook(Book b, EntityTransaction tx) {
        try {
            // Inserisco una riga nel db dei pagamenti
        }   catch(PersistenceException e) {
            throw new RuntimeException(e);
        }
    }
}
