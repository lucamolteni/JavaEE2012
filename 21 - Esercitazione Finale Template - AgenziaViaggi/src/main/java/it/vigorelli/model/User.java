package it.vigorelli.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@SequenceGenerator(name ="seqUser", sequenceName = "SEQ_USER")
public class User {
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
    private Set<Travel> travels = new HashSet<Travel>();

    public User() {
    }
    public User(long id) {
        this.id = id;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname, long id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public User(String name, String surname, String address, String email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqUser")
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Travel> getTravels() {
        return travels;
    }
    public void setTravels(Set<Travel> travels1) {
        this.travels = travels;
    }

    public void addTravel(Travel travel){
        this.getTravels().add(travel);
        travel.setUser(this);
    }
    public void removeTravel(Travel travel){
        this.getTravels().remove(travel);
        travel.setUser(null);
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("User");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
