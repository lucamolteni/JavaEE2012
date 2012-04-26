package it.vigorelli;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Pagamento.class)
public abstract class Pagamento_ {

	public static volatile SingularAttribute<Pagamento, Long> id;
	public static volatile SingularAttribute<Pagamento, Viaggio> viaggio;
	public static volatile SingularAttribute<Pagamento, Double> importo;

}

