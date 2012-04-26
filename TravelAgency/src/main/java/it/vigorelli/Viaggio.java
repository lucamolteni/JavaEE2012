package it.vigorelli;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@SequenceGenerator(name = "seqViaggio", sequenceName = "SEQ_VIAGGIO")
public class Viaggio {
    Long id;
    Utente utente;
    Localita localita;
    Set<Pagamento>pagamenti = new HashSet<Pagamento>();

    public Viaggio() {
    }

    public Viaggio(Utente utente, Localita localita){
        this.setLocalita(localita);
        this.setUtente(utente);
    }

    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqViaggio")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UTENTE_ID")
    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCALITA_ID")
    public Localita getLocalita() {
        return localita;
    }

    public void setLocalita(Localita localita) {
        this.localita = localita;
    }

    @OneToMany(mappedBy = "viaggio", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Pagamento> getPagamenti() {
        return pagamenti;
    }

    public void setPagamenti(Set<Pagamento> pagamenti) {
        this.pagamenti = pagamenti;
    }

    public void addPagamento(Pagamento pg1){
        this.getPagamenti().add(pg1);
        pg1.setViaggio(this);
    }

    public void removePagamento(Pagamento pg1){
        this.getPagamenti().remove(pg1);
        pg1.setViaggio(null);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Viaggio");
        sb.append("{idViaggio=").append(id);
        sb.append(", utente=").append(utente);
        sb.append(", localita=").append(localita);
//        sb.append(", pagamenti=").append(pagamenti);
        sb.append('}');
        return sb.toString();
    }
}
