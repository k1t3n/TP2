import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Facture {


	



	public static void main(String[] args) {
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void readFile() throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader( System.getProperty("user.dir") + "\\commandes.txt"));
			
			ArrayList<String> data = new ArrayList<String>();
			String currentLine;
			
			while ((currentLine = br.readLine()) != null) {
				data.add(currentLine);
			}
			
			br.close();
			
			try {
			createClients(data);
			createPlats(data);
			attribuerCommandes(data);
			printFactures();
			} catch (Exception e) {
				System.out.println("Le fichier ne respecte pas le format demandé !");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void createClients(ArrayList<String> info) {
		int debut = info.indexOf("Clients :");
		int fin = info.indexOf("Plats :");
		
		for (int i = debut + 1; i < fin; i++) {
			Client.listeClients.add(new Client(info.get(i)));
		}
		
	}
	
	public static void createPlats(ArrayList<String> info) {
		int debut = info.indexOf("Plats :");
		int fin = info.indexOf("Commandes :");
		
		for (int i = debut + 1; i < fin; i++) {
			String[] parts = info.get(i).split(" ");
			Plat.plats.add(new Plat(parts[0], Double.parseDouble(parts[1])));
		}
		
	}
	
	public static void attribuerCommandes(ArrayList<String> info) {
		int debut = info.indexOf("Commandes :");
		int fin = info.indexOf("Fin");
		
		for (int i = debut + 1; i < fin; i++) {
			String[] parts = info.get(i).split(" ");
			Client client = Client.getAvecNom(parts[0]);
			Plat plat = Plat.getAvecNom(parts[1]);
			Commande cmd = new Commande(client, plat, Integer.parseInt(parts[2]));
			client.commandes.add(cmd);
		}
	}
	
	public static void printClient() {
		Client.listeClients.forEach(client -> {
			System.out.println(client.toString());
		});
	}
	
	public static void printFactures() {
		System.out.println("Bienvenue chez Barette!");
		System.out.println("Factures:");
		DecimalFormat df =  new DecimalFormat("###,##0.00$"); 
		for (Client c : Client.listeClients) {
			System.out.println(c.nom + " " + df.format(c.getPrix()) );
		}
	}
	




}
