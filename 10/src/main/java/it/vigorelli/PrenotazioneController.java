package it.vigorelli;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

@Named
@ConversationScoped
public class PrenotazioneController implements Serializable {
    private Logger logger = Logger.getLogger(PrenotazioneController.class.getSimpleName());

    @Inject Prenotazione prenotazione;
    @Inject Conversation conversation;

    public String method1() {
          conversation.begin();
          logger.info(prenotazione.toString());
          return null;
    }

    public String method2() {
          conversation.end();
          return null;
    }

    public String method3() {
        logger.info(prenotazione.toString());
        return null;
    }



}
