package jpaPack;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.CitoyenDAO;
import dao.NationDAO;
import myPackage.Citoyen;
import myPackage.Nation;

public class jpaMain {	
	public static void main(String[] args) throws Exception {

		
		NationDAO dao = new NationDAO();
		int nbPop=70000000;
		
		List<Nation> nations=dao.nationsPluscitoyens(nbPop);
		
		System.out.println("\nNations qui ont plus de "+nbPop+ " populations :");
		for(Nation n :nations)
			System.out.println(n);
		
		//dao.modifierNbPopulation(2, 70000000);
		
		CitoyenDAO cidao = new CitoyenDAO();
		Citoyen peter= new Citoyen(1,"Amara","Peter",2);
		cidao.add(peter);
		
		List<Citoyen> citoyens =cidao.getAllCitoyen();
		
		System.out.println("Tous les cytoyens : ");
		for(Citoyen n :citoyens)
			System.out.println(n);
		
	}

}
