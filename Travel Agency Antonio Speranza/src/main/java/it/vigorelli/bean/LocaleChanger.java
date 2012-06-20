package it.vigorelli.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SessionScoped
@Named(value="localechanger")
public class LocaleChanger implements Serializable{

	public String englishAction() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(new Locale("en"));
		return null;
		}

	public String italianAction() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(new Locale("it"));
		return null;
		}


}