package it.vigorelli;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Indirizzo implements Serializable {
    private String via;
    private String numCivico;
    private String cap;
    private String citta;
    private String provincia;
    private String stato;

    public Indirizzo() {
    }

    public Indirizzo(String via, String numCivico, String cap, String citta, String provincia, String stato) {
        this.via = via;
        this.numCivico = numCivico;
        this.cap = cap;
        this.citta = citta;
        this.provincia = provincia;
        this.stato = stato;
    }

    @Column(name = "STREET")
    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    @Column(name = "STREET_NUM")
    public String getNumCivico() {
        return numCivico;
    }

    public void setNumCivico(String numCivico) {
        this.numCivico = numCivico;
    }

    @Column(name = "POSTAL_CODE")
    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    @Column(name = "TOWN")
    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Column(name = "DISTRICT")
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Column(name="COUNTRY")
    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Indirizzo");
        sb.append("{via='").append(via).append(" ").append(numCivico);
        sb.append(" '").append(cap).append(" ").append(citta).append(" ");
        sb.append(" (").append(provincia).append(")");
        sb.append(" - ").append(stato).append(" - ");
        sb.append('}');
        return sb.toString();
    }
}
