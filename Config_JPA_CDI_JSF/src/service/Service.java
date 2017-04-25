package service;

import java.util.List;

import javax.inject.Inject;

import dao.IDao;
import metier.Client;

public class Service implements Iservice {
	
	@Inject
	private IDao idao;
	
	@Override
	public long addClient(Client c) {
		// TODO Auto-generated method stub
		return idao.addClient(c);
	}
	
	
	@Override
	public List<Client> listerClient()
	{
		return idao.listerClient();
	}
	
	@Override
	public void supprimerClient(Client c)
	{
		idao.supprimerClient(c);
	}

	
	public void modifierClient(Client c)
	{
		idao.modifierClient(c);
	}
}
