package it.vigorelli;

import javax.persistence.*;

@Entity
@SequenceGenerator(name ="seqPurchase", sequenceName = "SEQ_PURCHASE")
public class Purchase {
    private Long id;
    private User user;
    private Book book;
    private Long discount;

    public Purchase() {
    }

    public Purchase(User user, Book book, Long discount) {
        this.user = user;
        this.book = book;
        this.discount = discount;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqPurchase")
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
    @JoinColumn(name = "BOOK_ID")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Purchase");
        sb.append("{id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", book=").append(book);
        sb.append(", discount=").append(discount);
        sb.append('}');
        return sb.toString();
    }
}
