package it.vigorelli.model;

import javax.persistence.*;

@Entity
@Table
@SequenceGenerator(name ="seqBankAccount", sequenceName = "SEQ_BANKACCOUNT")
public class BankAccount {
    private Long id;
    private User user;
    private String iban;
    private String addressBank;

    public BankAccount() {
    }

    public BankAccount(User user, String iban, String addressBank) {
        this.user = user;
        this.iban = iban;
        this.addressBank =addressBank;
    }



    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqBankAccount")
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

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }


    public String getAddressBank() {
        return addressBank;
    }

    public void setAddressBank(String addressBank) {
        this.addressBank = addressBank;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BankAccount");
        sb.append("{id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", iban=").append(iban);
        sb.append(", addressBank=").append(addressBank);
        sb.append('}');
        return sb.toString();
    }
}
