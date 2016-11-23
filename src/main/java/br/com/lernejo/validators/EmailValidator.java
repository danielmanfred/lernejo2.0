
package br.com.lernejo.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Classe responsável pela validação do e-mail
 * @author Daniel Tiago
 */
@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator
{

    /*
    Algoritmo de validação
    */
    @Override
    public void validate(FacesContext context, UIComponent component, Object object) throws ValidatorException 
    {
        String enteredEmail = (String)object;
        //Set the email pattern string
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        
        //Match the given string with the pattern
        Matcher m = p.matcher(enteredEmail);
        
        //Check whether match is found
        boolean matchFound = m.matches();
        
        if (!matchFound) {
            FacesMessage message = new FacesMessage();
            message.setDetail("E-mail incorreto!");
            message.setSummary("E-mail incorreto!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    
}
