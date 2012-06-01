package it.vigorelli;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@SequenceGenerator(name ="seqPublisher", sequenceName = "SEQ_PUBLISHER")
public class Publisher {
    private Long id;
    private String name;
    private String address;
    private Set<Book> book = new HashSet<Book>();

    public Publisher() {
    }

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqPublisher")
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

    public void addBook(Book b1) {
        getBook().add(b1);
        b1.setPublisher(this);
    }

    public void removeBook(Book b1) {
        getBook().remove(b1);
        b1.setPublisher(null);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Publisher");
        sb.append("{name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
