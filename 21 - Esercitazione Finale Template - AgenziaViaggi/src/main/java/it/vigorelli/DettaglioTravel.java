package it.vigorelli;

import it.vigorelli.model.Location;
import it.vigorelli.persistence.BookingTravelQuery;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class DettaglioTravel implements Serializable {
    Location location;
    @Inject BookingTravelQuery bookingTravelQuery;
    @Inject LoggedUser loggedUser;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String selectTravelLocation(Location location) {
        setLocation(location);
        return "dettaglioTravel";
    }

    public String book() {
        bookingTravelQuery.bookingTravel(loggedUser.getUser(), getLocation());
        return "success?faces-redirect=true";
    }

}
