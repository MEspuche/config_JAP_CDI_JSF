package dao;

import java.util.List;

import metier.Client;

public interface IDao {

	public long addClient(Client c);
	public List<Client> listerClient();
	public void supprimerClient(Client c);
	public void modifierClient(Client c);
}
