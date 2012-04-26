package it.vigorelli;

import javax.persistence.*;

@Entity
@SequenceGenerator( name = "seqCoordinateBancarie", sequenceName = "SEQ_COORDINATEBANCARIE" )
public class CoordinateBancarie {

    Long id;
    String iBan;
    Indirizzo indirizzoBanca;
    Utente utente;

    public CoordinateBancarie() {
    }

    public CoordinateBancarie(String iBan) {
        this.iBan = iBan;
    }

    public CoordinateBancarie(String iBan, Indirizzo indirizzoBanca) {
        this.iBan = iBan;
        this.indirizzoBanca = indirizzoBanca;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCoordinateBancarie")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getiBan() {
        return iBan;
    }

    public void setiBan(String iBan) {
        this.iBan = iBan;
    }

    public Indirizzo getIndirizzoBanca() {
        return indirizzoBanca;
    }

    public void setIndirizzoBanca(Indirizzo indirizzoBanca) {
        this.indirizzoBanca = indirizzoBanca;
    }

    @OneToOne(mappedBy = "contoBancario"
            , cascade = CascadeType.ALL
    )
    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CoordinateBancarie");
        sb.append("{idCB=").append(id);
        sb.append(", iBan='").append(iBan).append('\'');
        sb.append(", indirizzoBanca=").append(indirizzoBanca);
        sb.append(", utente=").append(utente);
        sb.append('}');
        return sb.toString();
    }
}
