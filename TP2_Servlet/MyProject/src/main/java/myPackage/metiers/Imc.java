package myPackage.metiers;

public class Imc {
	private double poids, taille;
	
	public Imc(double taille, double poids) {
		this.poids=poids;this.taille=taille;
	}
	
	public double calcul() {
		return poids/(taille*taille);
	}
	
	
}
