package it.vigorelli;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@SessionScoped
public class MyBean implements Serializable {
    private List<Persona> persone = new ArrayList<Persona>();

    @PostConstruct
    public void init() {
        persone.add(new Persona("Luca", "Molteni"));
        persone.add(new Persona("Fabio", "Polichetti"));
        persone.add(new Persona("Max", "Carbone"));
        persone.add(new Persona("Andrea", "Gelmini"));
    }

    public List<Persona> getPersone() {
        return persone;
    }

    public void setPersone(List<Persona> persone) {
        this.persone = persone;
    }

    public String salvaUtenti() {
        System.out.println("persone = " + persone);
        return null;
    }

    public String aggiungiUtente() {
        persone.add(new Persona());
        return null;
    }

    public String cancellaUtente(Persona p) {
        persone.remove(p);
        return null;
    }
}
