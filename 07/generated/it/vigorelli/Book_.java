package it.vigorelli;

import java.util.Date;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, String> author;
	public static volatile SetAttribute<Book, Purchase> purchasedUser;
	public static volatile SingularAttribute<Book, Long> price;
	public static volatile SingularAttribute<Book, Long> isbn;
	public static volatile SingularAttribute<Book, Date> publishDate;
	public static volatile SingularAttribute<Book, Publisher> publisher;
	public static volatile SingularAttribute<Book, String> bookName;

}

