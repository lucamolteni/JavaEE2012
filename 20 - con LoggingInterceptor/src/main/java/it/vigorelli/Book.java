package it.vigorelli;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table
@SequenceGenerator(name ="seqBook", sequenceName = "SEQ_BOOK")
public class Book {
    Long isbn;
    String bookName;
    Date publishDate;
    Long price;
    String author;
    Publisher publisher;

    public Book() {
    }

    public Book(String bookName, Long price, String author) {
        this.bookName = bookName;
        this.price = price;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqBook")
    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PUBLISHER_ID")
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Book");
        sb.append("{isbn='").append(isbn).append('\'');
        sb.append(", bookName='").append(bookName).append('\'');
        sb.append(", publishDate=").append(publishDate);
        sb.append(", price=").append(price);
        sb.append(", author='").append(author).append('\'');
        sb.append(", publisher=").append(publisher);
        sb.append('}');
        return sb.toString();
    }
}