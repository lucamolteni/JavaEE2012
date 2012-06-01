package it.vigorelli.persistence;

import it.vigorelli.model.Payment;
import it.vigorelli.model.Travel;
import it.vigorelli.model.User;
import it.vigorelli.util.EntityManagerBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class TravelDao {
    @PersistenceContext
    EntityManager em;

    public Travel findTravel(Long id) {
        return em.find(Travel.class, id);
    }

    public List<Travel> findTravelUser(User user) {
        TypedQuery<Travel> q1 = em.createQuery("select u from Travel t left join t.user u where u.id =:id  ", Travel.class);
        q1.setParameter("id", user.getId());
        return q1.getResultList();
    }

    public List<Payment> findPaymentsTravel(Travel travel) {
        TypedQuery<Payment> q1 = em.createQuery("select p from Payment p left join p.travel t where t.id =:id  ", Payment.class);
        q1.setParameter("id", travel.getId());
        return q1.getResultList();
    }

}