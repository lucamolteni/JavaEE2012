package it.vigorelli;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Purchase.class)
public abstract class Purchase_ {

	public static volatile SingularAttribute<Purchase, Long> id;
	public static volatile SingularAttribute<Purchase, Book> book;
	public static volatile SingularAttribute<Purchase, User> user;
	public static volatile SingularAttribute<Purchase, Long> discount;

}

