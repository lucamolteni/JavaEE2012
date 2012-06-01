package it.vigorelli.persistence;

import it.vigorelli.model.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserQuery {
    @PersistenceContext
    EntityManager em;

    public List<User> findAllUser() {
        TypedQuery<User> q1 = em.createQuery("select u from User u", User.class);
        return  q1.getResultList();
    }

    public User findUser(Long id) {
        return em.find(User.class, id);
    }

    public List<Payment> findUserPayments(String addressBank) {
        final TypedQuery<Payment> q1 = em.createQuery("select u from Payment u left join u.travel.user.bankAccounts b where b.addressBank=:addressBank", Payment.class);
        q1.setParameter("addressBank", addressBank);
        return q1.getResultList();
    }


}