package it.vigorelli;

import org.hibernate.annotations.common.util.impl.LoggerFactory;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
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

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Book save(Book book) {
        return em.merge(book);
    }
}
