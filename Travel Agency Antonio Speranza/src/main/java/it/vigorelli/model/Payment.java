package it.vigorelli.model;

import javax.persistence.*;

@Entity
@Table
@SequenceGenerator(name ="seqPayment", sequenceName = "SEQ_PAYMENT")
public class Payment {
    private Long id;
    private Long amount;
    protected Travel travel;


    public Payment() {
    }

    public Payment(Travel travel, Long amount) {
        this.amount = amount;
        this.travel = travel;
    }
    
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqPayment")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRAVEL_ID")
    public Travel getTravel() {
        return travel;
    }
    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", travel=" + travel +
                '}';
    }
}
