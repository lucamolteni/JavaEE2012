package it.vigorelli;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Publisher.class)
public abstract class Publisher_ {

	public static volatile SingularAttribute<Publisher, Long> id;
	public static volatile SingularAttribute<Publisher, String> address;
	public static volatile SingularAttribute<Publisher, String> name;
	public static volatile SetAttribute<Publisher, Book> book;

}

