package it.vigorelli.validator;

import javax.faces.validator.*;
import javax.faces.application.*;
import javax.faces.component.*;
import javax.faces.context.*;
import java.util.regex.*; 

import javax.faces.validator.Validator;

@FacesValidator("it.vigorelli.validator.EmailValidator")
public class EmailValidator  implements Validator
{
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
			"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
			"(\\.[A-Za-z]{2,})$";
 
	private Pattern pattern;
	private Matcher matcher;
 
	public EmailValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	}
 
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
 
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
 
			FacesMessage msg = 
				new FacesMessage("E-mail validation failed.", "Email non formalmente valida");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
 
		}
 
	}
}