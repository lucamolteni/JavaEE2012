package it.vigorelli;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Localita.class)
public abstract class Localita_ {

	public static volatile SingularAttribute<Localita, Long> id;
	public static volatile SetAttribute<Localita, Viaggio> viaggi;
	public static volatile SingularAttribute<Localita, Indirizzo> indirizzoLocalita;
	public static volatile SingularAttribute<Localita, Double> costo;
	public static volatile SingularAttribute<Localita, String> nome;
	public static volatile SingularAttribute<Localita, Paese> paese;

}

