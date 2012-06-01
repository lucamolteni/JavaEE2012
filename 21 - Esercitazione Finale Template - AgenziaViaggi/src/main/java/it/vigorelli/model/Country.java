package it.vigorelli.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@SequenceGenerator(name ="seqCountry", sequenceName = "SEQ_COUNTRY")
public class Country {
    private Long id;
    private String name;
    private String regionalCode;
    private Set<Location> locations = new HashSet<Location>();

    public Country() {
    }

    public Country(String name, String regionalCode) {
        this.name = name;
        this.regionalCode = regionalCode;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqCountry")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegionalCode() {
        return regionalCode;
    }

    public void setRegionalCode(String regionalCode) {
        this.regionalCode = regionalCode;
    }

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public void addLocation(Location b1) {
        getLocations().add(b1);
        b1.setCountry(this);
    }

    public void removeBook(Location b1) {
        getLocations().remove(b1);
        b1.setCountry(null);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Country");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", regionalCode='").append(regionalCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
