package it.vigorelli;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

enum Pages {
    secondaPagina, index2
}


@RequestScoped
@Named
public class ControllerBean {
    public final static String SECONDA_PAGINA = "secondaPagina";
    public final static String INDEX2 = "index2";

    public Pages metodo1() {
        System.out.println("Vado verso " +
                "la seconda pagina");
        return Pages.secondaPagina;

    }

    public Pages metodo2() {
        System.out.println("Vado verso " +
                "la prima pagina");
        return Pages.index2;

    }
}
