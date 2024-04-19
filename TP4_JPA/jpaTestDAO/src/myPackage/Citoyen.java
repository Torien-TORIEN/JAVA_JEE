package myPackage;
import javax.persistence.*;

@Entity @Table(name="Citoyens")
public class Citoyen {
	@Id
	private int id;
	private String nom;
	private String prenom;
	
	@Column(name = "id_nation")
	private int pays_naiss;
	
	public Citoyen(int id , String no, String pr, int nat) {
		this.id=id;nom=no;prenom=pr;pays_naiss=nat;
	}
	
	
	public Citoyen() {
		id=0;
		nom="unknown";
		prenom="unknown";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getPays_naiss() {
		return pays_naiss;
	}

	public void setPays_naiss(int pays_naiss) {
		this.pays_naiss = pays_naiss;
	}

	@Override
	public String toString() {
		return "Citoyen [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", pays_naiss=" + pays_naiss + "]";
	}
	
}
