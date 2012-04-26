package it.vigorelli.DAO;

import it.vigorelli.*;

import javax.persistence.*;

public abstract class PrenotazioneDAO implements ReportDAO {
    private static EntityManagerFactory managerFactory;

    public abstract void inserisciPrenotazione(Utente utente, Viaggio viaggio);
    public abstract void effettuaPagamento(Viaggio viaggio, Pagamento pagamento);
    public abstract void annullaViaggio(Utente ut, Viaggio viaggio);

    public PrenotazioneDAO() {
        getEntityManager();
    }
    
    public Utente findUtente(Long idUtente){
        return getEntityManager().find(Utente.class,idUtente);
    }
    
    public Viaggio findViaggio(Long idViaggio){
        return  getEntityManager().find(Viaggio.class,idViaggio);
    }
    public Paese findPaese(Long idPaese){
        return getEntityManager().find(Paese.class,idPaese);
    }
    public Localita findLocalita(Long idLocalita){
        return getEntityManager().find(Localita.class, idLocalita);
    }
    public Pagamento findPagamento(Long idPagamento){
        return  getEntityManager().find(Pagamento.class, idPagamento);
    }

    public static EntityManager getEntityManager(){
        if(managerFactory == null)
            managerFactory = Persistence.createEntityManagerFactory("travelAgencyPersistenceUnit");
        return managerFactory.createEntityManager();
    }

}
