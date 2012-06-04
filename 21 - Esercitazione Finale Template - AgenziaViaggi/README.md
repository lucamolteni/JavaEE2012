Traccia esercitazione finale corso Java EE 2012 C.F.P. Vigorelli
========================================================================

Si tratta di integrare il DAO creato nella prima esercitazione in una rich web application utilizzando JSF, CDI e EJB, modificando il template
dell'esercizio 21 fornito.

Saranno implementate tre diverse pagine web:

## index.xhtml

Dove inizia l'applicazione e dove sarà visualizzata la lista delle destinazioni dove si può prenotare un viaggio in una dataTable.
Per prenotare un viaggio si cliccherà su di un link che mandera ad una pagina di dettaglio, salvando l'oggetto in un bean.

## dettaglio.xhtml

Dove una schermata di dettaglio con la destinazione chiederà conferma all'utente se si vuole fare una prenotazione. I contenuti di questa
pagina sono implementabili a piacere, ma dovrebbe dare evidenza del viaggio che si sta prenotando in questo momento.
Vi deve essere un pulsante di conferma creazione del viaggio.

## success.xhtml

Dove viene dato un messaggio di conferma dell'avvenuta prenotazione e una lista delle prenotazioni correnti (con ui:repeat).

Tutti gli EJB sono già forniti dal template, e sono il DAO precedentemente creato con le annotation @Stateless, @Stateful e
l'injection del persistence context. Verrà fornito anche un EJB singleton per il prepopolamento dei dati.
Tutti gli EJB sono modificabili a piacere, ma non è richiesto per lo svolgimento corretto dell'esercizio.

Dovranno essere creati almeno due bean CDI, uno contenente l'oggetto di dettaglio (in scope session) e l'altro l'utente loggato (sempre in scope session).
Non è richiesto implementare l'autenticazione, si può inserire un utente scelto dal database durante la fase @PostConstruct.

Punti in più per chi:

1) Utilizza lo scope conversation per il bean che contiene l'oggetto di dettaglio, e quindi fa partire le conversation sul link di index.
2) Implementa l'autenticazione in una pagina a parte.
3) Utilizza i meccanismi di template per creare una struttura del sito condivisa tra le pagine.

Buon lavoro :)

L.M.