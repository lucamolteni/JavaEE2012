package it.vigorelli;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.Arrays;
import java.util.logging.Logger;

public class LogginInterceptor implements Serializable {
    private Logger logger = Logger.getLogger(LogginInterceptor.class.getSimpleName());

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.info(String.format("Entrando in %s %s %s"
                , ic.getTarget().toString()
                , ic.getMethod().toString()
                , Arrays.toString(ic.getParameters())));
        try {
            Object proceed = ic.proceed();
            logger.info("Valore di ritorno: " + proceed);
            return proceed;
        } catch (Exception e) {
            logger.fine("C'è stato un errore: " + e.getMessage());
            throw e;
        } finally {
            logger.info(String.format("Uscendo in %s %s %s"
                    , ic.getTarget().toString()
                    , ic.getMethod().toString()
                    , Arrays.toString(ic.getParameters())));
        }
    }
}
