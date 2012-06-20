package it.vigorelli.businesslogic;

import java.io.Serializable;

import it.vigorelli.bean.UserBean;
import it.vigorelli.model.Location;
import it.vigorelli.model.Travel;
import it.vigorelli.persistence.BookingTravelQuery;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ConversationScoped
@Named(value="bookingTravel")
public class BookingTravel  implements Serializable{

    @Inject BookingTravelQuery bookingTravelQuery;
    @Inject UserBean userBean;
    @Inject Conversation conversation;
    
    private Location location;
    private Travel travel;   
	
	
	public Conversation getConversation() {
	        return conversation;
	}
	
	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}
       
    public String chooseLocation(Location location)
    {
    	conversation.begin();
    	this.location = location;
    	return "detailTravel";
    }

  
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String booking() {
    	bookingTravelQuery.bookingTravel(userBean.getUserEntity(), location);
    	conversation.end();
        return "userListTravel";
    }
    
	public String removeTravel(Travel travel)
	{
		bookingTravelQuery.deleteTravel(travel);
		return "userListTravel";
	}

	public String terminateConversation()
	{
		conversation.end();
		return "userListTravel";
	}

}
