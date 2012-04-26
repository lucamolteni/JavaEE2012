package it.vigorelli.DAO;


import it.vigorelli.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PrenotazioneHQLImpl extends PrenotazioneDAO implements ReportDAO
{

    public PrenotazioneHQLImpl() {
        super();
    }

    // override dei metodi di inserimento Prenotazione
    @Override
    public void inserisciPrenotazione(Utente utente, Viaggio viaggio) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        utente = em.merge(utente);
        utente.addViaggio(viaggio);
        em.getTransaction().commit();
        em.close();
     }

    @Override
    public void effettuaPagamento(Viaggio viaggio, Pagamento pagamento) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        viaggio = em.merge(viaggio);
        viaggio.addPagamento(pagamento);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void annullaViaggio(Utente utente, Viaggio viaggio) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        utente = em.merge(utente);
        viaggio = em.merge(viaggio);
        utente.removeViaggio(viaggio);
        viaggio.getLocalita().removeViaggio(viaggio);
        em.remove(viaggio);
        em.getTransaction().commit();
        em.close();
    }

    // implementazione dei metodi di query dell'interfaccia ReportDAO
    @Override
    public Utente getUtenteByEmail(String eMail) {
        Utente ut = (Utente)getEntityManager().createQuery("select u from Utente u WHERE eMail = :param")
                .setParameter("param",eMail).getSingleResult();
        return ut;
    }

    @Override
    public List<Localita> getListaLocalita() {
        List<Localita> loc = (List<Localita>)getEntityManager().createQuery("select l from Localita l left join" +
                " l.paese p").getResultList();
        return loc;
    }


    @Override
    public List<Localita> getListaLocalita(Paese paese) {
        List<Localita> loc = (List<Localita>)getEntityManager().createQuery("select l from Localita l left join" +
                " l.paese p WHERE p.regionalCode = :param").setParameter("param",paese.getRegionalCode()).getResultList();
        return loc;
    }

    @Override
    public List<Viaggio> getViaggiByUtente(Utente utente) {
        List<Viaggio> ut = (List<Viaggio>)getEntityManager().createQuery("select v from Viaggio v left join v.utente u where " +
                "u.id = :param").setParameter("param",utente.getId()).getResultList();
        return ut;
    }

    @Override
    public List<Pagamento> getPagamentiByViaggio(Viaggio viaggio) {
        List<Pagamento> pg = (List<Pagamento>)getEntityManager().createQuery("select p from Pagamento p left join p.viaggio v " +
                "where v.id = :param").setParameter("param",viaggio.getId()).getResultList();
        return pg;
    }

    @Override
    public List<Pagamento> getTransazioniBanca(Indirizzo indirizzoBanca) {
         List<Pagamento> pg = (List<Pagamento>)getEntityManager().createQuery("select p from Pagamento p left join " +
                 "p.viaggio.utente.contoBancario b WHERE b.indirizzoBanca = :param")
                 .setParameter("param",indirizzoBanca).getResultList();
         return pg;
    }
}
