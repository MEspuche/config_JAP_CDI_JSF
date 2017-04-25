package service;

import java.util.List;

import metier.Client;

public interface Iservice {

	public long addClient(Client c);
	public List<Client> listerClient();
	public void supprimerClient(Client c);
	public void modifierClient(Client c);
}
