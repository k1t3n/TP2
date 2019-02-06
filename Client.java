import java.util.ArrayList;

public class Client {

	public static ArrayList<Client> listeClients = new ArrayList<Client>();
	
	
	String nom;
	ArrayList<Commande> commandes;
	
	
	public Client() {
		
	}
	
	
	public Client(String nom) {
		this.nom = nom;
		this.commandes = new ArrayList<Commande>();
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nom);
		for (Commande cmd : commandes) {
			sb.append(" " + cmd.plat.nom + " " + cmd.quantite);
		}
		return sb.toString();
	}
	
	
	public static Client getAvecNom(String nom) {
		for (Client c : listeClients) {
			if (c.nom.equals(nom)) {
				return c;
			}
		}
		return null;
	}
	
	public double getPrix() {
		double prix = 0;
		for (Commande cmd : commandes) {
			prix += cmd.plat.prix * cmd.quantite;
		}
		return prix;
	}
	
}
