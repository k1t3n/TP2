import java.util.ArrayList;

public class Plat {

	public static ArrayList<Plat> plats = new ArrayList<Plat>();
	
	String nom;
	double prix;
	
	public Plat(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
	}
	
	
	public static Plat getAvecNom(String nom) {
		for (Plat p : plats) {
			if (p.nom.equals(nom)) {
				return p;
			}
		}
		return null;
	}
	
}
