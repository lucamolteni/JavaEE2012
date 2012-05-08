package it.vigorelli;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SessionScoped
@Named
public class Bean implements Serializable {
    private String nome;
    private Integer numUtenti;
    private Map<String, Integer> mappa = new HashMap<String, Integer>();

    @PostConstruct
    public void init() {
        mappa.put("luca", 27);
        mappa.put("max", 35);
    }

    public Map<String, Integer> getMappa() {
        return mappa;
    }

    public void setMappa(Map<String, Integer> mappa) {
        this.mappa = mappa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumUtenti() {
        return numUtenti;
    }

    public void setNumUtenti(Integer numUtenti) {
        this.numUtenti = numUtenti;
    }

    public String saluta(String s) {
       System.out.println("Ciao " + s);
       return null;
    }
}
