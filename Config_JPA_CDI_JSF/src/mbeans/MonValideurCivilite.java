package mbeans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator 
public class MonValideurCivilite implements Validator{

	public void validate(FacesContext facesContext, UIComponent component, Object value ) throws ValidatorException
	{
		String inputData = value.toString();
		if(inputData.equals(null))
		{
			FacesMessage msg = new FacesMessage("Erreur de saisie");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
	
}
