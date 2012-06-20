package it.vigorelli.model;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;


@Entity
@Table
@SequenceGenerator(name ="seqTravel", sequenceName = "SEQ_TRAVEL")
public class Travel {
    private Long id;
    private User user;
    private Location location;
    private Set<Payment> payments = new HashSet<Payment>();

    public Travel() {
    }

    public Travel( long id) {
        this.id = id;
    }

    public Travel(User user, long id) {
        this.user = user;
        this.id = id;
    }

    public Travel(User user, Location location) {
        this.user = user;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqTravel")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }
     public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCATION_ID")
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL)
    public Set<Payment> getPayments() {
        return payments;
    }
    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public void addPayment(Payment payment){
        this.getPayments().add(payment);
        payment.setTravel(this);
    }
    public void removePayment(Payment payment){
        this.getPayments().remove(payment);
        payment.setTravel(null);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Travel");
        sb.append("{id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", location=").append(location);
        sb.append('}');
        return sb.toString();
    }
}
