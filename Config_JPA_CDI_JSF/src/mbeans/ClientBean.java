package mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import metier.Client;
import service.Iservice;

//@ManagedBean
@ViewScoped
@Named
public class ClientBean {

	@Inject
	private Iservice service;
	private Client client = new Client();
	private List<Client> colclient = new ArrayList<Client>();
	private boolean editmode = false;

	public boolean isEditmode() {
		return editmode;
	}

	public void setEditmode(boolean editmode) {
		this.editmode = editmode;
	}

	public List<Client> getColclient() {
		return service.listerClient();
	}

	public void setColclient(List<Client> colclient) {
		this.colclient = colclient;
	}

	public Iservice getService() {
		return service;
	}

	public void setService(Iservice service) {
		this.service = service;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String add() {
		if(editmode==false)
		{
			if(!client.getNom().equalsIgnoreCase("") && !client.getPrenom().equalsIgnoreCase(""))
			{
				service.addClient(client);
				client = new Client();
			}
			else
			{
				FacesContext context =  FacesContext.getCurrentInstance();
				context.addMessage("client", new FacesMessage("veuillez saisir des valeurs non nulles"));
				client = new Client();
			}
		}
		else
		{
			if(!(client.getNom().equalsIgnoreCase("") && client.getPrenom().equalsIgnoreCase("")))
			{
				service.modifierClient(client);
				editmode = false;
				client = new Client();
			}
			else
			{
				FacesContext context =  FacesContext.getCurrentInstance();
				context.addMessage("client", new FacesMessage("veuillez saisir des valeurs non nulles"));
				client = new Client();
			}
		}
		return "index";
	}

	public String lister() {
		colclient = service.listerClient();
		return "index";
	}

	public String supprimer(Client c) {
		service.supprimerClient(c);

		return "index";
	}

	public void maj() {
		editmode = true;
	}

}
