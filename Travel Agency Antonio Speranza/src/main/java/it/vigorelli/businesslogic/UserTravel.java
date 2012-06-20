package it.vigorelli.businesslogic;

import it.vigorelli.bean.UserBean;
import it.vigorelli.model.BankAccount;
import it.vigorelli.model.Country;
import it.vigorelli.model.Location;
import it.vigorelli.model.Travel;
import it.vigorelli.model.User;
import it.vigorelli.persistence.CountryQuery;
import it.vigorelli.persistence.LocationQuery;
import it.vigorelli.persistence.TravelQuery;
import it.vigorelli.persistence.UserQuery;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.service.spi.InjectService;

import java.util.List;
import java.util.Set;

@Named (value="userTravel")
@RequestScoped
public class UserTravel {

    @Inject UserQuery userQuery;
    @Inject TravelQuery travelQuery;
    @Inject LocationQuery locationQuery;
    
    @Inject UserBean userBean;
    
    @SuppressWarnings("unchecked")
    @Produces
    @Named
    @RequestScoped
    public List<Travel> getAllTravelUser() {
        return travelQuery.findTravelUser(userBean.getUserEntity());
    }
    
    public List<User> getAllUser() {
        return userQuery.findAllUser();
    }
    
    @SuppressWarnings("unchecked")
    @Produces
    @Named
    @RequestScoped
    public List<Location> getAllLocation() {
        return locationQuery.findAllLocation();
    }

    public List<BankAccount> getBankUser() {
    	return  userQuery.findUserBank(userBean.getUserEntity());
    }
    
    
}
