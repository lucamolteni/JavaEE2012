package it.vigorelli;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class Data {
    @PersistenceContext
    EntityManager em;

    @Inject PublisherQuery publisherQuery;

    @PostConstruct
    public void init() {
        Publisher p1 = new Publisher("Publisher1", "Address1");
        Book b1 = new Book("Book1", 23l, "Luca Molteni");
        Book b2 = new Book("Book2", 10l, "Luca Molteni");
        p1.addBook(b1);
        p1.addBook(b2);
        Publisher p2 = new Publisher("Publisher2", "Address2");
        Publisher p3 = new Publisher("Publisher3", "Address3");
        publisherQuery.addPublisher(p1, p2, p3);
    }
}
