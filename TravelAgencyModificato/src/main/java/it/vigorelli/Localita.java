package it.vigorelli;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@SequenceGenerator(name = "seqLocalita", sequenceName = "SEQ_LOCALITA")
public class Localita {

    Long id;
    String nome;
    Indirizzo indirizzoLocalita;
    Paese paese;
    double costo;
    Set<Viaggio> viaggi = new HashSet<Viaggio>();

    public Localita() {
    }

    public Localita(String nome, Indirizzo indirizzoLocalita, Paese paese, double costo) {
        this.nome = nome;
        this.indirizzoLocalita = indirizzoLocalita;
        this.paese = paese;
        this.costo = costo;
    }

    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLocalita")
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

    public Indirizzo getIndirizzoLocalita() {
        return indirizzoLocalita;
    }

    public void setIndirizzoLocalita(Indirizzo indirizzoLocalita) {
        this.indirizzoLocalita = indirizzoLocalita;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAESE_ID")
    public Paese getPaese() {
        return paese;
    }

    public void setPaese(Paese paese) {
        this.paese = paese;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }


    @OneToMany(mappedBy = "localita", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Viaggio> getViaggi() {
        return viaggi;
    }

    public void setViaggi(Set<Viaggio> viaggi) {
        this.viaggi = viaggi;
    }

    public void removeViaggio(Viaggio vg1){
        this.getViaggi().remove(vg1);
        vg1.setLocalita(null);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Localita");
        sb.append("{idLocalita=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", indirizzoLocalita=").append(indirizzoLocalita);
        sb.append(", paese=").append(paese);
        sb.append(", costo=").append(costo);
//        sb.append(", viaggi=").append(viaggi);
        sb.append('}');
        return sb.toString();
    }
}
