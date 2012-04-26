package it.vigorelli;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Indirizzo.class)
public abstract class Indirizzo_ {

	public static volatile SingularAttribute<Indirizzo, String> citta;
	public static volatile SingularAttribute<Indirizzo, String> stato;
	public static volatile SingularAttribute<Indirizzo, String> via;
	public static volatile SingularAttribute<Indirizzo, String> cap;
	public static volatile SingularAttribute<Indirizzo, String> numCivico;
	public static volatile SingularAttribute<Indirizzo, String> provincia;

}

