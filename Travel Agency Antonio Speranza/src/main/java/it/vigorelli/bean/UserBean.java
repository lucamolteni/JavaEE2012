package it.vigorelli.bean;

import it.vigorelli.model.User;
import it.vigorelli.persistence.UserQuery;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named(value="user")
public class UserBean implements Serializable
{
	@Inject UserQuery userQuery;
	private String username;
	private String surname;
	private User  userEntity;
	
	public User getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(User userEntity) {
		this.userEntity = userEntity;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String email;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	 public String getAuth() 
	 {
		 String outcome = "";
		 try {

			 User user = userQuery.findUser(username, surname, email);
			 if(user !=null)
			 {
				 setUserEntity(user);
				 outcome = "Home";
			 }
			 
		} catch (Exception e) {
			    e.printStackTrace();
				outcome = "failure";
		}
    	return outcome;
	 }
	
	 
}