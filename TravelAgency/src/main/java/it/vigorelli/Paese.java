package it.vigorelli;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@SequenceGenerator(name = "seqPaese", sequenceName = "SEQ_PAESE")
public class Paese {

    Long id;
    String nome;
    String regionalCode;
    Set<Localita>localitas=new HashSet<Localita>();

    public Paese() {
    }

    public Paese(String nome, String regionalCode) {
        this.nome = nome;
        this.regionalCode = regionalCode;
    }

    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPaese")
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

    public String getRegionalCode() {
        return regionalCode;
    }

    public void setRegionalCode(String regionalCode) {
        this.regionalCode = regionalCode;
    }

    @OneToMany(mappedBy = "paese", cascade = CascadeType.ALL)
    public Set<Localita> getLocalitas() {
        return localitas;
    }

    public void setLocalitas(Set<Localita> localitas) {
        this.localitas = localitas;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Paese");
        sb.append("{idPaese=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", regionalCode='").append(regionalCode).append('\'');
//        sb.append(", località=").append(localitas);
        sb.append('}');
        return sb.toString();
    }
}
