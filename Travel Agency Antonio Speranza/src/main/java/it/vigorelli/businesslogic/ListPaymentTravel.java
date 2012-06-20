package it.vigorelli.businesslogic;

import it.vigorelli.model.Payment;
import it.vigorelli.model.Travel;
import it.vigorelli.persistence.BookingTravelQuery;
import it.vigorelli.persistence.TravelQuery;

import java.io.Serializable;
import java.util.List;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named (value="listPaymentTravel")
public class ListPaymentTravel implements Serializable{
    @Inject TravelQuery travelQuery;
    @Inject BookingTravelQuery bookingTravelQuery;

    private Travel travel;
	private long idTravel = 0l;
    private long amount   = 0l;
    
    public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}
    
	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
    
    @SuppressWarnings("unchecked")
    @Produces
    @Named
    @RequestScoped
    public List<Payment> getAllPaymentUser() {
   	    return travelQuery.findPaymentsTravel(travel);
    }
    
    public String addPayment()
    {
    	bookingTravelQuery.paymentTravel(travel, amount);
    	return "userListTravel";
    }
    
    public String chooseTravel(Travel t)
    {
    	travel = t;
    	
    	return "paymentListTravel";
    }
    
}

    
    
