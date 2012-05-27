package it.vigorelli;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ElencoPublisher {

    @EJB
    PublisherQuery publisherQuery;

    @EJB BookQuery bookQuery;

    // @Inject PublisherQuery publisherQuery;

    public List<Publisher> getPublisher() {
        return publisherQuery.getAllPublisher();
    }

    public List<Book> getBooks() {
        return bookQuery.getAllBooks();
    }
}
