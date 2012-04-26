package it.vigorelli;

import javax.persistence.*;

@Entity@SequenceGenerator(name = "seqPagamento", sequenceName = "SEQ_PAGAMENTO")
public class Pagamento {

    Long id;
    Viaggio viaggio;
    double importo;
    //ci starebbe bene anche una descrizione della voce di prezzo

    public Pagamento() {
    }

    public Pagamento(Viaggio viaggio, double importo) {
        this.viaggio = viaggio;
        this.importo = importo;
    }

    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPagamento")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIAGGIO_ID")
    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }


    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Pagamento");
        sb.append("{idPagamento=").append(id);
        sb.append(", viaggio=").append(viaggio);
        sb.append(", importo=").append(importo);
        sb.append('}');
        return sb.toString();
    }
}
