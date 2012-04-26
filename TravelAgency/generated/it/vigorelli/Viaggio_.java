package it.vigorelli;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Viaggio.class)
public abstract class Viaggio_ {

	public static volatile SingularAttribute<Viaggio, Long> id;
	public static volatile SingularAttribute<Viaggio, Localita> localita;
	public static volatile SingularAttribute<Viaggio, Utente> utente;
	public static volatile SetAttribute<Viaggio, Pagamento> pagamenti;

}

