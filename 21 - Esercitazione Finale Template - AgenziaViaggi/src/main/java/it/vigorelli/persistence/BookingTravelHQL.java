package it.vigorelli.persistence;

import it.vigorelli.model.*;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class BookingTravelHQL
{
    @PersistenceContext(type = PersistenceContextType.EXTENDED) EntityManager entityManager;
    @Inject LocationQuery locationDao;
    @Inject UserQuery userDao;
    @Inject TravelDao travelDao;

    public Travel bookingTravel(User user, Location location)
    {
        final Location l = locationDao.findLocation(location.getId());
        final User u = userDao.findUser(user.getId());
        final Travel travel = new Travel(user,location);
        user.addTravel(travel);
        return entityManager.merge(travel);
    }

    public Travel paymentTravel(Travel travel, long amount) {
        final Travel t = travelDao.findTravel(travel.getId());
        final Payment payment = new Payment(travel,amount);
        travel.addPayment(payment);
        return entityManager.merge(travel);
    }

    public boolean deleteTravel(Travel travel) {
        final Travel t = travelDao.findTravel(travel.getId());
        entityManager.remove(t);
        return true;
    }

    @Remove
    public void destroy() {

    }
}