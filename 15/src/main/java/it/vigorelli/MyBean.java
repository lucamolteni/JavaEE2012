package it.vigorelli;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@SessionScoped
@Named
public class MyBean implements Serializable {
    private Boolean myBooleanValue;
    private List<Integer> citta = new ArrayList<Integer>();
    private Set<Citta> cittaDisponibili = new HashSet<Citta>();

    @PostConstruct
    public void init() {
        cittaDisponibili.add(new Citta("Milano", 20010));
        cittaDisponibili.add(new Citta("Roma", 20090));
        cittaDisponibili.add(new Citta("Venezia", 20133));
    }

    public List<Integer> getCitta() {
        return citta;
    }

    public void setCitta(List<Integer> citta) {
        this.citta = citta;
    }

    private Integer mioNumero;
    private Set<String> colori = new TreeSet<String>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });

    public Integer getMioNumero() {
        return mioNumero;
    }

    public void setMioNumero(Integer mioNumero) {
        this.mioNumero = mioNumero;
    }

    public void setColori(Set<String> colori) {
        this.colori = colori;
    }

    public Set<String> getColori() {
        return colori;
    }

    public Boolean getMyBooleanValue() {
        return myBooleanValue;
    }

    public void setMyBooleanValue(Boolean myBooleanValue) {
        this.myBooleanValue = myBooleanValue;
    }

    public String myAction() {
        System.out.println("myBooleanValue = " + myBooleanValue);
        System.out.println("colori = " + colori);
        System.out.println("mioNumero = " + mioNumero);
        System.out.println("citta = " + citta);
        return "select";
    }

    public void setCittaDisponibili(Set<Citta> cittaDisponibili) {
        this.cittaDisponibili = cittaDisponibili;
    }

    public Set<Citta> getCittaDisponibili() {
        return cittaDisponibili;
    }
}
