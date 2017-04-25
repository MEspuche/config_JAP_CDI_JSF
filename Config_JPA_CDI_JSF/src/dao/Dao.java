package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Client;

public class Dao implements IDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpacdi-pu");
	
	@Override
	public long addClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
		return c.getId();
	}
	
	@Override
	public List<Client> listerClient()
	{
		EntityManager em = emf.createEntityManager();
		List<Client> listClient = em.createQuery("SELECT a FROM Client a").getResultList();
		em.close();
		return listClient;
	}
	@Override
	public void supprimerClient(Client c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Client cl = em.find(Client.class, c.getId());
		em.remove(cl);
		tx.commit();
		em.close();
	}

	@Override
	public void modifierClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
		
	}

}
