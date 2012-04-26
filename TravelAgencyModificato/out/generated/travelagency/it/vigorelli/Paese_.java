package it.vigorelli;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Paese.class)
public abstract class Paese_ {

	public static volatile SingularAttribute<Paese, Long> id;
	public static volatile SetAttribute<Paese, Localita> localitas;
	public static volatile SingularAttribute<Paese, String> nome;
	public static volatile SingularAttribute<Paese, String> regionalCode;

}

