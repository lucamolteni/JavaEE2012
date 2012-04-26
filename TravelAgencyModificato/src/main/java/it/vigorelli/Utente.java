package it.vigorelli;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@SequenceGenerator(name = "seqUtente", sequenceName = "SEQ_UTENTE")
public class Utente {

    Long id;
    String nome;
    String cognome;
    String eMail;
    Indirizzo indirizzo;  // implementato con @Embedded
    CoordinateBancarie contoBancario; // CoordinateBancarie x relazione OneToOne
    Set<Viaggio> viaggi = new HashSet<Viaggio>();

    public Utente() {
    }

    public Utente(String nome, String cognome, String eMail, Indirizzo indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.eMail = eMail;
        this.indirizzo = indirizzo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUtente")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    @OneToOne
    @JoinColumn(name = "COORDINATEBANCARIE_ID")
    public CoordinateBancarie getContoBancario() {
        return contoBancario;
    }

    public void setContoBancario(CoordinateBancarie contoBancario) {
        this.contoBancario = contoBancario;
    }


    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    public Set<Viaggio> getViaggi() {
        return viaggi;
    }

    public void setViaggi(Set<Viaggio> viaggi) {
        this.viaggi = viaggi;
    }

    public void addViaggio(Viaggio vg1){
        this.getViaggi().add(vg1);
        vg1.setUtente(this);
    }
    public void removeViaggio(Viaggio vg1){
        this.getViaggi().remove(vg1);
        vg1.setUtente(null);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Utente");
        sb.append("{idUtente=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", cognome='").append(cognome).append('\'');
        sb.append(", eMail='").append(eMail).append('\'');
        sb.append(", indirizzo=").append(indirizzo);
//        sb.append(", contoBancario=").append(contoBancario);
//      sb.append(", viaggio=").append(viaggio);
        sb.append('}');
        return sb.toString();
    }
}
