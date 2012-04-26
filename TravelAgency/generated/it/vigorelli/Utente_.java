package it.vigorelli;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Utente.class)
public abstract class Utente_ {

	public static volatile SingularAttribute<Utente, Long> id;
	public static volatile SetAttribute<Utente, Viaggio> viaggi;
	public static volatile SingularAttribute<Utente, Indirizzo> indirizzo;
	public static volatile SingularAttribute<Utente, String> eMail;
	public static volatile SingularAttribute<Utente, String> nome;
	public static volatile SingularAttribute<Utente, CoordinateBancarie> contoBancario;
	public static volatile SingularAttribute<Utente, String> cognome;

}

