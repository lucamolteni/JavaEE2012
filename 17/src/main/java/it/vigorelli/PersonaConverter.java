package it.vigorelli;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Persona.class
        , value = "personaConverter")
public class PersonaConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String[] split = value.split(",");
        return new Persona(split[0], split[1]);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Persona p = (Persona) value;
        return  p.getNome() + "," + p.getCognome();
    }
}
