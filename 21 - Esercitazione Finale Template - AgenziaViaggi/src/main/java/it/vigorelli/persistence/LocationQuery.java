package it.vigorelli.persistence;

import it.vigorelli.model.Location;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Stateless
public class LocationQuery {
    @PersistenceContext
    EntityManager em;

    public Location findLocation(Long id) {
        return em.find(Location.class, id);
    }

    public List<Location> findAllLocation() {
        TypedQuery<Location> q1 = em.createQuery("select u from Location u", Location.class);
        return q1.getResultList();
    }


}