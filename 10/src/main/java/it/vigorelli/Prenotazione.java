package it.vigorelli;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

@Named
@ConversationScoped
public class Prenotazione implements Serializable {
    private String viaggioCorrente;
    private Logger logger = Logger.getLogger(Prenotazione.class.getSimpleName());

    @PostConstruct
    public void init() {
        logger.info("Ho creato Prenotazione");
    }

    public String getViaggioCorrente() {
        return viaggioCorrente;
    }

    public void setViaggioCorrente(String viaggioCorrente) {
        this.viaggioCorrente = viaggioCorrente;
    }

    @PreDestroy
    public void destroy() {
        logger.info("Ho distrutto prenotazione");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Prenotazione");
        sb.append("{viaggioCorrente='").append(viaggioCorrente).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
