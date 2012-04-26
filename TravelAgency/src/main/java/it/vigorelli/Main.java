package it.vigorelli;


import javax.persistence.*;
import java.util.List;
import java.util.Vector;
import it.vigorelli.DAO.*;

public class Main {
    private String eMailTest;
    private static Indirizzo indiTest = new Indirizzo("via Marconi","12","20060", "Cassina De' Pecchi", "MI", "Italia");

    public Main(String eMailTest) {
        this.eMailTest = eMailTest;
    }

    public static void main(String[] args) {
        setUp(); /* inserisco i valori nel DB */

        PrenotazioneDAO pr = new PrenotazioneCriteriaImpl();

        /* Inizializzo alcuni attributi della classe Main per testare le query*/
        Main ex01 = new Main("mikethepenguin@gmail.it");
//
        /* Stampo l'utente corrispondente all'e-mail inserita */
        System.out.printf(("\n********** Utente con e-mail = %S : **********\n"
        +pr.getUtenteByEmail(ex01.eMailTest)),ex01.eMailTest);


        /* Stampo l'elenco delle località con relativo paese */
        System.out.println("\n\n********** Lista delle Località e Paesi **********\n");
        for(Object p : pr.getListaLocalita())
            System.out.println("-----------------------------------------------\n "+p);


//        /* Stampo l'elenco delle località con paese paeseTest */
        System.out.println("\n********** Lista delle Località per Paese = Sudafrica **********\n");
        Paese paeseTest = pr.findPaese(51l);
        for(Localita l : pr.getListaLocalita(paeseTest))
            System.out.println("-----------------------------------------------\n "+l);

//        /* Stampo l'elenco dei viaggi con utente michele bonsignore */
        System.out.println("\n********** Lista dei viaggi per utente = michele bonsignore **********\n");
        Utente utTest = pr.findUtente(50l);
        for(Viaggio v : pr.getViaggiByUtente(utTest))
            System.out.println("-----------------------------------------------\n "+v);

        /* Stampo l'elenco dei pagamenti abbinati al viaggio di michele al Protea Hotel (2 pagamenti) */
       System.out.println("\n********** Lista dei pagamenti per viaggio michele bonsignore presso Protea Hotel Fire & Ice! **********\n");
        Viaggio vgTest = pr.findViaggio(51l);
        for(Pagamento p : pr.getPagamentiByViaggio(vgTest)){
            System.out.println("-----------------------------------------------\n "+p);
        }

        /* Stampo l'elenco delle transazioni effettuate dalla banca con sportello all'indirizzo scelto */
       System.out.println("\n********** Lista delle transazioni di tutti gli utenti da banca di via Marconi 12 **********\n");
        for(Pagamento p : pr.getTransazioniBanca(indiTest)){
            System.out.println("-----------------------------------------------\n "+p);
        }


       /*Prenoto un viaggio a Kabul per michele*/
        final Utente michele = pr.findUtente(50l);
        final Localita kabul = pr.findLocalita(50l);

        pr.inserisciPrenotazione(michele,new Viaggio(michele,kabul));
        System.out.println("\n********** Prenotazione viaggio per Kabul **********\n");
        System.out.println(pr.findViaggio(53l));

        /* Effettuo il pagamento per confermare la prenotazione */
        final Viaggio viaggioKabul = pr.findViaggio(53l);
        pr.effettuaPagamento(viaggioKabul,new Pagamento(viaggioKabul,1200.00));
        System.out.println("\n********** Ricevuta di pagamento del viaggio per Kabul **********\n");
        System.out.println(pr.findPagamento(54l));


        /* Annullamento del viaggio e cancellazione dei pagamenti */
        pr.annullaViaggio(pr.getUtenteByEmail(ex01.eMailTest),viaggioKabul);
        System.out.println("\n********** Annullamento del viaggio per Kabul **********\n");
        System.out.println("Viaggio = " + pr.findViaggio(53l));
        System.out.println("Pagamenti = " + pr.findPagamento(54l));
    }

    private static void setUp() {
        PrenotazioneDAO pr = new PrenotazioneCriteriaImpl();
        final EntityManager em = pr.getEntityManager();
        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        /* Inserimento utente 1 */
        final Indirizzo id1 = new Indirizzo("via Sandro Pertini","2/A","20060", "Cassina De' Pecchi", "MI", "Italia");
        final Indirizzo indBanca = new Indirizzo("via Marconi","12","20060", "Cassina De' Pecchi", "MI", "Italia");
        final Utente ut1 = new Utente("Michele", "Bonsignore","mikethepenguin@gmail.it",id1);
        final CoordinateBancarie c1 = new CoordinateBancarie("12135646464",indBanca);
        ut1.setContoBancario(c1);
        c1.setUtente(ut1);
        em.persist(c1);
        em.persist(ut1);

        /* Inserimento utente 2 */
        final Indirizzo id2 = new Indirizzo("via Sandro Pertini","2/A","20060", "Cassina De' Pecchi", "MI", "Italia");
        final Utente ut2 = new Utente("Monica", "Limonta","monilimo@yahoo.it",id2);
        final CoordinateBancarie c2 = new CoordinateBancarie("12135647878",indBanca);
        ut2.setContoBancario(c2);
        c2.setUtente(ut2);
        em.persist(c2);
        em.persist(ut2);

        /* Inserimento Paesi e Località */
        final Paese p1 = new Paese("Afganistan", "0093");
        final Paese p2 = new Paese("Sudafrica","0027");
        final Paese p3 = new Paese("Messico", "0052");

        final Indirizzo ind1 = new Indirizzo("Char Rahi Ansari"," "," ","Kabul", "Kabul","Afghanistan");
        final Localita l1P1 = new Localita("Safi Landmark Hotel Suites Hotel",ind1,p1,1200.00);

        final Indirizzo ind2 = new Indirizzo("Orange Street","76","8001", "Cape Town","Cape Town","Sudafrica");
        final Localita l1P2 = new Localita("The Mount Nelson Hotel by Orient-Express",ind2,p2,2200.00);
        final Indirizzo ind3 = new Indirizzo("New Church Str","","8001", "Cape Town","Cape Town","Sudafrica");
        final Localita l2P2 = new Localita("Protea Hotel Fire & Ice!",ind3,p2,2800.00);

        final Indirizzo ind4 = new Indirizzo("Río Lerma","154","06500", "Cuauhtémoc","Ciudad de México, Distrito Federal","Messico");
        final Localita l1P3 = new Localita("Colonna dell'indipendenza",ind4,p3,3200.00);
        em.persist(l1P1);em.persist(l1P2);em.persist(l2P2);em.persist(l1P3);
        em.persist(p1);em.persist(p2);em.persist(p3);

        /* Inserimento viaggi per Utente1 */
        final Viaggio vg1 = new Viaggio(ut1,l1P2);
        final Pagamento pg1 = new Pagamento(vg1, 2200.00);
        ut1.addViaggio(vg1); vg1.addPagamento(pg1);

        final Viaggio vg2 = new Viaggio(ut1,l2P2);
        final Pagamento pg2 = new Pagamento(vg2, 1000.00);
        final  Pagamento pg3 = new Pagamento(vg2, 1800.00);
        ut1.addViaggio(vg2);  vg2.addPagamento(pg2); vg2.addPagamento(pg3);
        em.persist(vg1); em.persist(vg2);
        /* Inserimento viaggi per Utente2 */
        final Viaggio vg3 = new Viaggio(ut2, l2P2);
        final  Pagamento pg4 = new Pagamento(vg2, 2800.00);
        ut2.addViaggio(vg3); vg3.addPagamento(pg4);
        em.persist(vg3);

        tx.commit();
        em.close();
    }
}
