/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {

    Pattern p = Pattern.compile("[A-Za-z]+@[A-Za-z]+");

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = (String) value;
        Pattern p = Pattern.compile("[A-Za-z]+@[A-Za-z]+");
        if (!p.matcher(email).matches()) {
            throw new ValidatorException(new FacesMessage(ResourceBundle.getBundle("resources.bundle").getString("invalidemail")));
        }

    }

}
