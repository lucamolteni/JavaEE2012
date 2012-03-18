package it.vigorelli;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {
    private Long id;
    private String name;
    private Contact primaryContact;
    private Set<Contact> secondaryContacts;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(Contact primaryContact) {
        this.primaryContact = primaryContact;
    }

    @ElementCollection
      @CollectionTable(
            name="ORDERS_SECONDARY_CONTACT",
            joinColumns=@JoinColumn(name="ORDER_ID")
      )
    public Set<Contact> getSecondaryContacts() {
        return secondaryContacts;
    }

    public void setSecondaryContacts(Set<Contact> secondaryContacts) {
        this.secondaryContacts = secondaryContacts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Orders");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", primaryContact=").append(primaryContact);
        sb.append(", secondaryContacts=").append(secondaryContacts);
        sb.append('}');
        return sb.toString();
    }
}