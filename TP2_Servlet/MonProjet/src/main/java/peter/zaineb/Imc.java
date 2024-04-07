package peter.zaineb;

public class Imc {
	private double poids,taille;
	public Imc(double p,double t) {
		poids=p;taille=t;
	}
	
	public double calcul() {
		return poids/(taille*taille);
	}
}
