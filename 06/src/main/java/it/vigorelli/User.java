package it.vigorelli;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@SequenceGenerator(name ="seqUser", sequenceName = "SEQ_USER")
public class User {
    private Long id;
    private String name;
    private String surname;
    private String account;
    private String email;
    private Set<Purchase> purchasedBooks = new HashSet<Purchase>();

    public User() {
    }

    public User(String name, String surname, String account, String email) {
        this.name = name;
        this.surname = surname;
        this.account = account;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Purchase> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void setPurchasedBooks(Set<Purchase> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("User");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", account='").append(account).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
