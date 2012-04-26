package it.vigorelli.DAO;

import it.vigorelli.*;

import javax.persistence.TypedQuery;
import java.util.List;


public interface ReportDAO {
    public Utente getUtenteByEmail(String eMail);
    public List<Localita> getListaLocalita();
    public List<Localita> getListaLocalita(Paese paese);
    public List<Viaggio> getViaggiByUtente(Utente utente);
    public List<Pagamento> getPagamentiByViaggio(Viaggio viaggio);
    public  List<Pagamento> getTransazioniBanca(Indirizzo indirizzoBanca);
}
