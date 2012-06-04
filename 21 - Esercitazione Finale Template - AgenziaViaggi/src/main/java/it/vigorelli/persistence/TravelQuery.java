package it.vigorelli.persistence;

import it.vigorelli.model.Payment;
import it.vigorelli.model.Travel;
import it.vigorelli.model.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Named
public class TravelQuery {
    @PersistenceContext
    EntityManager em;

    public Travel findTravel(Long id) {
        return em.find(Travel.class, id);
    }

    public List<Travel> findTravelUser(User user) {
        TypedQuery<Travel> q1 = em.createQuery(
                "select t from Travel t left join t.user u " +
                "left join fetch t.location " +
                "where u.id =:id  ", Travel.class);
        q1.setParameter("id", user.getId());
        return q1.getResultList();
    }

    public List<Payment> findPaymentsTravel(Travel travel) {
        TypedQuery<Payment> q1 = em.createQuery("select p from Payment p left join p.travel t where t.id =:id  ", Payment.class);
        q1.setParameter("id", travel.getId());
        return q1.getResultList();
    }

}