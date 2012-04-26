package it.vigorelli.DAO;

import it.vigorelli.*;

import javax.persistence.criteria.*;
import java.util.List;

public class PrenotazioneCriteriaImpl extends PrenotazioneHQLImpl {

    public PrenotazioneCriteriaImpl() {
        super();
    }

    @Override
    public Utente getUtenteByEmail(String eMail) {
        final CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<Utente> criteria = cb.createQuery(Utente.class);
        final Root<Utente> root = criteria.from(Utente.class);
        criteria.select(root);
        criteria.where(cb.equal(root.get(Utente_.eMail),eMail));
        return getEntityManager().createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Localita> getListaLocalita() {
        final CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<Localita> criteria = cb.createQuery(Localita.class);
        final Root<Localita> root = criteria.from(Localita.class);
        criteria.select(root);
        root.join(Localita_.paese);
        return getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<Localita> getListaLocalita(Paese paese) {
        final CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<Localita> criteria = cb.createQuery(Localita.class);
        final Root<Localita> root = criteria.from(Localita.class);
        criteria.select(root);
        final Join<Localita, Paese> localitaPaeseJoin = root.join(Localita_.paese);
        criteria.where( cb.equal(localitaPaeseJoin.get(Paese_.regionalCode),paese.getRegionalCode()) );
        return getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<Viaggio> getViaggiByUtente(Utente utente) {
        final CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<Viaggio> criteria = cb.createQuery(Viaggio.class);
        final Root<Viaggio> root = criteria.from(Viaggio.class);
        criteria.select(root);
        final Join<Viaggio, Utente> viaggioUtenteJoin = root.join(Viaggio_.utente);
        root.join(Viaggio_.localita);
        criteria.where( cb.equal(viaggioUtenteJoin.get(Utente_.eMail),utente.geteMail()) );
        return getEntityManager().createQuery(criteria).getResultList();
    }
}
