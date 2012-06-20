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

    public User findUser(String mail) {
        TypedQuery<User> q1 = em.createQuery("select u from User u where u.email = :email", User.class);
        q1.setParameter("email", mail);
        return  q1.getSingleResult();
    }

    public User findUser(String name, String surname, String mail) {
        TypedQuery<User> q1 = em.createQuery("select u from User u where u.email = :email and u.name = :name and u.surname = :surname", User.class);
        q1.setParameter("name", name);
        q1.setParameter("surname", surname);
        q1.setParameter("email", mail);
        return  q1.getSingleResult();
    }

    public List<Payment> findUserPayments(String addressBank) {
        final TypedQuery<Payment> q1 = em.createQuery("select u from Payment u left join u.travel.user.bankAccounts b where b.addressBank=:addressBank", Payment.class);
        q1.setParameter("addressBank", addressBank);
        return q1.getResultList();
    }

    public List<BankAccount> findUserBank(User user) {
    	final TypedQuery<BankAccount> q1 = em.createQuery("select t from BankAccount t left join t.user u where u.id =:id  ", BankAccount.class);
        q1.setParameter("id", user.getId());
        return q1.getResultList();
    }

    

}