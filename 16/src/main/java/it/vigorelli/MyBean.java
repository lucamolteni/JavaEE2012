package it.vigorelli;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class MyBean implements Serializable {
    private Integer numero;
    private String[] nomi =
            new String[]{"Luca", "Pippo", "Pluto", "Paperino"};

    private List<List<Integer>> numeri = new ArrayList<List<Integer>>(10);

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            final List<Integer> lista = new ArrayList<Integer>();
            for (int t = 0; t < 20; t++) {
                lista.add(t + i);
            }
            numeri.add(lista);
        }
    }

    public List<List<Integer>> getNumeri() {
        return numeri;
    }

    public void setNumeri(List<List<Integer>> numeri) {
        this.numeri = numeri;
    }

    public String[] getNomi() {
        return nomi;
    }

    public void setNomi(String[] nomi) {
        this.nomi = nomi;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String myAction() {
        return null;
    }
}
