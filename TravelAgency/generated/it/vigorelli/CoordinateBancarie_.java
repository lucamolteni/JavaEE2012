package it.vigorelli;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CoordinateBancarie.class)
public abstract class CoordinateBancarie_ {

	public static volatile SingularAttribute<CoordinateBancarie, Long> id;
	public static volatile SingularAttribute<CoordinateBancarie, Indirizzo> indirizzoBanca;
	public static volatile SingularAttribute<CoordinateBancarie, Utente> utente;
	public static volatile SingularAttribute<CoordinateBancarie, String> iBan;

}

