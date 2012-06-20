package it.vigorelli;

import it.vigorelli.model.BankAccount;
import it.vigorelli.model.Country;
import it.vigorelli.model.Location;
import it.vigorelli.model.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class Data {
    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init() {
        final User user1 = new User("Luca", "Molteni", "via della torre milano", "luca.molteni@me.com");
        final User user2 = new User("Antonio", "Speranza", "via cadorna paderno", "antonio.speranza@gmail.com");

        // creazione coordinate bancarie per utenti
        final BankAccount bankAccount = new BankAccount(user1, "0000000aaa900000", "banca mps via torino");
        final BankAccount bankAccount2 = new BankAccount(user2, "0000000aaa900001", "banca unicredit via milano");

        // creazione localita
        final Location location = new Location();
        final Location location1 = new Location();
        final Location location2 = new Location();

        location.setName("Playamaroma");
        location.setExpense(100L);

        location1.setName("Cancun");
        location1.setExpense(100L);

        location2.setName("Merida");
        location2.setExpense(100L);

        // creazione paesi
        final Country country1 = new Country();
        final Country country2 = new Country();

        country1.setName("Messico");
        country1.setRegionalCode("00001");
        country1.addLocation(location);
        country1.addLocation(location1);
        country1.addLocation(location2);

        em.persist(user1);
        em.persist(user2);
        em.persist(bankAccount);
        em.persist(bankAccount2);
        em.persist(country1);
    }
}
