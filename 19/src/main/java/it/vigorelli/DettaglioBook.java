package it.vigorelli;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.io.Serializable;

@ConversationScoped
@Named
public class DettaglioBook implements Serializable {
    @Inject BookQuery bookQuery;
    @Inject Conversation conversation;

    @PostConstruct
    public void init() {
        if(conversation.isTransient()) {
            conversation.begin();
        }
    }

    private Long id;
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        if(book == null && id != null) {
            book = bookQuery.find(id);
        }
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String save() {
        bookQuery.save(getBook());
        return "DettaglioBook";
    }
}
