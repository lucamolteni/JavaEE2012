package it.vigorelli;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PublisherQuery {
    @PersistenceContext EntityManager em;

    public List<Publisher> getAllPublisher() {
        return em.createQuery(
                "select p from Publisher p"
                , Publisher.class).getResultList();
    }

    public void addPublisher(Publisher p) {
        em.persist(p);
    }

    public void addPublisher(Publisher... pub) {
        for(Publisher p : pub) {
            addPublisher(p);
        }
    }
}
