package jpaPack;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import myPackage.Nation;

public class jpaMain {
	
	public static void  lister(EntityManager entityManager  ) {
		Query q = entityManager.createQuery( "from Nation" , Nation.class );
		List<Nation> nations ;
		nations = q.getResultList();
		
		for (Nation n : nations) {
			System.out.println( n.toString() );
		}
	}
	
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf ;
		emf = Persistence.createEntityManagerFactory("UniteUnionEurope");
		EntityManager entityManager = emf.createEntityManager();
		Query q = entityManager.createQuery( "from Nation" , Nation.class );
		List<Nation> nations ;
		nations = q.getResultList();
		
		for (Nation n : nations) {
			System.out.println( n.toString() );
		}
		
		// Ajout d'un nouvel enregistrement
		entityManager.getTransaction().begin(); // Début de la transaction
		Nation nation = new Nation(7, "Belgique", 11690000); // Création d'une nouvelle instance de Nation
		entityManager.persist(nation); // Ajout de la nouvelle Nation à la base de données
		entityManager.getTransaction().commit(); // Validation de la transaction
		
		// Afficher la liste
		System.out.println("\nApres l'ajout :");
		lister(entityManager);
		
		
		// Mise à jour d'un enregistrement
		entityManager.getTransaction().begin(); // Début de la transaction
		Nation nationToUpdate = entityManager.find(Nation.class, 7); // Récupération de l'entité à mettre à jour
		nationToUpdate.setNom("Bulgarie"); // Modification de l'attribut
		entityManager.getTransaction().commit(); // Validation de la transaction
		
		// Afficher la liste
		System.out.println("\nApres la modification :");
		lister(entityManager);
		
		
		//Suppression d'un enregistrement
		entityManager.getTransaction().begin(); // Début de la transaction
		Nation nationToDelete = entityManager.find(Nation.class, 7); // Récupération de l'entité à supprimer
		entityManager.remove(nationToDelete); // Suppression de l'entité de la base de données
		entityManager.getTransaction().commit(); // Validation de la transaction
		
		// Afficher la liste
		System.out.println("\nApres la suppression :");
		lister(entityManager);
		
		
	}

}
