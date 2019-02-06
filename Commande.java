
public class Commande {
	
	
	
	Client client;
	Plat plat;
	int quantite;
	
	public Commande(Client client, Plat plat, int quantite) {
		this.client = client;
		this.plat = plat;
		this.quantite = quantite;
	}
	
	@Override
	public String toString() {
		return "Client " + client.nom + " Plat " + plat.nom + " Quantite " + quantite;
	}
	
	
	
	
}
