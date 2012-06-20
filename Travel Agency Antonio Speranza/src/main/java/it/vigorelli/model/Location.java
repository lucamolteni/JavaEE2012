package it.vigorelli.model;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;
@Entity
@Table
@SequenceGenerator(name ="seqLocation", sequenceName = "SEQ_LOCATION")
public class Location {
    private Long id;
    private Country country;
    private String name;
    private Long expense;
    private Set<Travel> travels = new HashSet<Travel>();

    public Location() {
    }

    public Location(String name, long id) {
        this.name = name;
        this.id =id;
    }

    public Location(String name, Long expense) {
        this.name = name;
        this.expense =expense;
    }


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqLocation")
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


    public Long getExpense() {
        return expense;
    }

    public void setExpense(Long expense) {
        this.expense = expense;
    }

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    public Set<Travel> getTravels() {
        return travels;
    }
    public void setTravels(Set<Travel> travels) {
        this.travels = travels;
    }

    public void addTravel(Travel travel){
        this.getTravels().add(travel);
        travel.setLocation(this);
    }
    public void removeTravel(Travel travel){
        this.getTravels().remove(travel);
        travel.setLocation(null);
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Location");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", expense=").append(expense);
        sb.append('}');
        return sb.toString();
    }
}
