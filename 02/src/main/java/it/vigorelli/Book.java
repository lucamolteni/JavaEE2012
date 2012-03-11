package it.vigorelli;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Book {
    String isbn;
    String bookName;
    String publisherCode;
    Date publishDate;
    Long price;
    String author;

    @Id
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(String publisherCode) {
        this.publisherCode = publisherCode;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Book");
        sb.append("{isbn='").append(isbn).append('\'');
        sb.append(", bookName='").append(bookName).append('\'');
        sb.append(", publisherCode='").append(publisherCode).append('\'');
        sb.append(", publishDate=").append(publishDate);
        sb.append(", price=").append(price);
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }
}