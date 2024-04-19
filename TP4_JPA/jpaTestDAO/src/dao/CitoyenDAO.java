package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import myPackage.Citoyen;
import myPackage.Nation;

public class CitoyenDAO implements ICitoyenDAO {
private EntityManager entityManager;
	
	public CitoyenDAO() {
		EntityManagerFactory emf ;
		emf = Persistence.createEntityManagerFactory("UniteUnionEurope");
		entityManager = emf.createEntityManager();
	}

	@Override
	public void add(Citoyen c) {
		// TODO Auto-generated method stub
		// Ajout d'un nouvel enregistrement
		entityManager.getTransaction().begin(); // Début de la transaction
		entityManager.persist(c); // Ajout de la nouvelle Nation à la base de données
		entityManager.getTransaction().commit(); // Validation de la transaction
		
	}

	@Override
	public List<Citoyen> getAllCitoyen() {
		Query q = entityManager.createQuery( "from Citoyen" , Citoyen.class );
		List<Citoyen> citoyens ;
		citoyens = q.getResultList();
		return citoyens;
	}
}
