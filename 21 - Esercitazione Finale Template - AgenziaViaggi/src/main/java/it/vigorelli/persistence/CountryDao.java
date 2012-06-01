package it.vigorelli.persistence;

import it.vigorelli.model.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CountryDao {
    @PersistenceContext
    EntityManager em;

    public Country findCountry(Long id) {
        return em.find(Country.class, id);
    }

    public List<Country> findAllCountry() {
        TypedQuery<Country> q1 = em.createQuery("select u from Country u", Country.class);
        return q1.getResultList();
    }
}