import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*@author Mathieu-FIX - 2022
 * @since 1.0
*/
public class Formation {
	protected static Map <Integer,ArrayList<String>> formation = new HashMap<>();
	protected static Map <Integer,ArrayList<String>> pannier = new HashMap<>();
	protected static Map <Integer,ArrayList<String>> futurFormation = new HashMap<>();
	private static int sum;
	private static String name ;
	private static Scanner scan = new Scanner(System.in);
	// Méthode Main (Appel des différentes fonctionalités du programme)
	public static void main(String[] args) {
		nameUser();
		listeFormations();
		futurListeFormations();
		displayFormations();
		creatPannier();
		scan.close();
	}
	public static void nameUser() {
		System.out.println("Entrer votre Nom :");
		name = scan.next().toUpperCase();
		
	}
	/** displayFormations
	 * @param formation permet d'afficher la liste des formations
	 * */
	public static void displayFormations() {
		System.out.println("         Bonjour et bienvenue dans mon application FullTrainings");
		System.out.println("Nous allons vous proposer une liste de formation actuellement disponible");
		System.out.println("-------------------------------------------------------------------------");
		System.out.printf("%-14s | %-8s | %-36s |%-4s |\n","COURS", "NB/JOURS", "DESCRIPTION", " PRIX");
		System.out.println("---------------|----------|--------------------------------------|------|");
		formation.entrySet()
		.stream()
		.forEach(e -> System.out.printf("%-14s | %-8s | %-36s | %-4s |\n",e.getValue().get(0),e.getValue().get(1),e.getValue().get(2),e.getValue().get(3)));	
		System.out.println("-------------------------------------------------------------------------");
	}
	/**seeFormations
	 * */
	
	public static void seeFormations() {
		System.out.println(" Liste de formation actuellement disponible");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.printf("%5s |%-14s | %-8s | %-36s |%-4s |\n","ID","COURS", "NB/JOURS", "DESCRIPTION", " PRIX");
		System.out.println("------|---------------|----------|--------------------------------------|------|");
		formation.entrySet()
		.stream()
		.forEach(e -> System.out.printf("%5s |%-14s | %-8s | %-36s | %-4s |\n",e.getKey(),e.getValue().get(0),e.getValue().get(1),e.getValue().get(2),e.getValue().get(3)));	
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(" ");
	}
	/** futurFormations
	 * @param futurFormation permet d'afficher les futures formations
	 * */
	public static void futurFormations() {
		
		System.out.println("          Liste des formations bientôt disponible ");
		System.out.println("-------------------------------------------------------------------------");
		System.out.printf("%-14s | %-8s | %-36s |%-4s |\n","COURS", "NB/JOURS", "DESCRIPTION", " PRIX");
		System.out.println("---------------|----------|--------------------------------------|------|");
		futurFormation.entrySet()
		.stream()
		.forEach(e -> System.out.printf("%-14s | %-8s | %-36s | %-4s |\n",e.getValue().get(0),e.getValue().get(1),e.getValue().get(2),e.getValue().get(3)));	
		System.out.println("-------------------------------------------------------------------------");
		System.out.println(" ");
	}
	/**seePannier
	 * @param pannier permet de voir le pannier
	 * **/
	public static void seePannier() {
		if (total ()>0) {
		System.out.println(" Voici votre pannier "+name+" : ");
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s|%-14s | %-8s | %-36s |%-5s |%10s|%10s|\n","ID","COURS", "NB/JOURS", "DESCRIPTION", " PRIX ","QUANTITE","TOTAL");
		System.out.println("-----|---------------|----------|--------------------------------------|-------|----------|----------|");
		pannier.entrySet()
		.stream()
		.forEach(e -> {if(Integer.parseInt(e.getValue().get(4)) > 0) {System.out.printf("%5s|%-14s | %-8s | %-36s | %-5s |%10s|%10s|\n",e.getKey(),e.getValue().get(0),e.getValue().get(1),e.getValue().get(2),e.getValue().get(3),  e.getValue().get(4) ,  e.getValue().get(5));}});	
		System.out.println("-----|---------------|----------|--------------------------------------|-------|----------|----------|");
		System.out.printf("%5s|%-14s | %-8s | %-36s |%-5s %-11s %11s|\n"," "," ", " ", "                             ","","    TOTAL :",  total ());
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("");
		}else {
			System.out.println(" Votre pannier est vide "+ name);
			System.out.println(" ");
		}
	}

	/**seeBuy
	 * permet de voir le panier avant validation du pannier
	 * **/
	public static void seeBuy() {
		System.out.println("                           Voici votre pannier "+name+" :");
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s|%-14s | %-8s | %-36s |%-5s |%10s|%10s|\n","ID","COURS", "NB/JOURS", "DESCRIPTION", " PRIX ","QUANTITE","TOTAL");
		System.out.println("-----|---------------|----------|--------------------------------------|-------|----------|----------|");
		pannier.entrySet()
		.stream()
		.forEach(e -> {if (Integer.parseInt(e.getValue().get(4)) >0) {System.out.printf("%5s|%-14s | %-8s | %-36s | %-5s |%10s|%10s|\n",e.getKey(),e.getValue().get(0),e.getValue().get(1),e.getValue().get(2),e.getValue().get(3),e.getValue().get(4),e.getValue().get(5));}});	
		System.out.println("-----|---------------|----------|--------------------------------------|-------|----------|----------|");
		System.out.printf("%5s|%-14s | %-8s | %-36s |%-5s %-11s %11s|\n"," "," ", " ", "                             ","","    TOTAL :",  total ());
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println(" ");
		
	}
	
	/**listeFormations
	 *permet de créer le tableau des formations
	 * **/
	private static void listeFormations() {
	formation.put(1,new ArrayList<String>());
	formation.get(1).add("Java"); formation.get(1).add("20");formation.get(1).add("Java SE 8 : Syntaxe & Poo");formation.get(1).add("3000");formation.get(1).add("1");formation.get(1).add("0");
	formation.put(2,new ArrayList<String>());
	formation.get(2).add("Java avancé"); formation.get(2).add("20");formation.get(2).add("Exceptions, fichiers,Jdbc, thread...");formation.get(2).add("5000");formation.get(2).add("1");formation.get(2).add("0");
	formation.put(3,new ArrayList<String>());
	formation.get(3).add("Spring"); formation.get(3).add("20");formation.get(3).add("Spring Core/Mvc/Security");formation.get(3).add("5000");formation.get(3).add("1");formation.get(3).add("0");
	formation.put(4,new ArrayList<String>());
	formation.get(4).add("Php frameworks"); formation.get(4).add("15");formation.get(4).add("Symphony");formation.get(4).add("2500");formation.get(4).add("1");formation.get(4).add("0");
	formation.put(5,new ArrayList<String>());
	formation.get(5).add("C#"); formation.get(5).add("20");formation.get(5).add("DotNet Core");formation.get(5).add("5000");formation.get(5).add("1");formation.get(5).add("0");
	}
	
	/**futurListeFormations
	 * permet de créer le tableau des futures formations
	 * **/
	private static void futurListeFormations() {
	futurFormation.put(1,new ArrayList<String>());
	futurFormation.get(1).add("htlm"); futurFormation.get(1).add("10");futurFormation.get(1).add("Syntaxe ");futurFormation.get(1).add("1500");futurFormation.get(1).add("1");futurFormation.get(1).add("0");
	futurFormation.put(2,new ArrayList<String>());
	futurFormation.get(2).add("Css"); futurFormation.get(2).add("10");futurFormation.get(2).add("Syntaxe, mise en forme..");futurFormation.get(2).add("1500");futurFormation.get(2).add("1");futurFormation.get(2).add("0");
	futurFormation.put(3,new ArrayList<String>());
	futurFormation.get(3).add("Js"); futurFormation.get(3).add("20");futurFormation.get(3).add("JavaScript ");futurFormation.get(3).add("5000");futurFormation.get(3).add("1");futurFormation.get(3).add("0");
	futurFormation.put(4,new ArrayList<String>());
	futurFormation.get(4).add("PHP My Admin"); futurFormation.get(4).add("20");futurFormation.get(4).add("Base de donnée");futurFormation.get(4).add("4000");futurFormation.get(4).add("1");futurFormation.get(4).add("0");
	futurFormation.put(5,new ArrayList<String>());
	futurFormation.get(5).add("VSCode"); futurFormation.get(5).add("10");futurFormation.get(5).add("Utilisation");futurFormation.get(5).add("1500");futurFormation.get(5).add("1");futurFormation.get(5).add("0");
	}
	
	/**total
	 * méthode de calcul du total final
	 * **/
	public static int total () {
		sum = 0 ;
		pannier.entrySet()
		.stream()
		.forEach(e -> sum += Integer.parseInt(e.getValue().get(5)));
		return sum;
		}


	/**creatPannier
	 * affichage du menu
	 * **/
	public static void creatPannier() {
		int choice = 0;
		System.out.println("Faites votre choix dans le menu, saisissez le chiffre correspondant :\n");
		while(choice != 6) {
			System.out.println("1 : Afficher la liste des formations");
			System.out.println("2 : Afficher mon pannier");
			System.out.println("3 : Ajouter une formation");
			System.out.println("4 : Supprimer une formation");
			System.out.println("5 : Valider votre panier");
			System.out.println("6 : Quitter le pannier");
			
			while(!scan.hasNextInt())	scan.next();
			choice = scan.nextInt();			
			switch(choice) {
			
				case 1 : 
						seeFormations();
						break;
				
				case 2 :
						System.out.println(" ");
						if (pannier.containsKey(1)) {
							seePannier();
						}else {
							System.out.println("Votre pannier est vide "+name);
							System.out.println(" ");
						}
						break;
									
				case 3 :
						System.out.println("saisissez l'id de la formation");
						int idForma = scan.nextInt();		
						if(formation.get(idForma)!= null) {
							if(pannier.get(idForma)== null ) {
								//rajouter une formation
								pannier.put(idForma, formation.get(idForma));
							}
							else {
								//incrémenter la valeur de qté
								int qte = Integer.parseInt(pannier.get(idForma).get(4));
								++qte;	
								pannier.get(idForma).set(4, String.valueOf(qte));
							}
							//calcule le résultat de chaque ligne
							int quantity = Integer.parseInt(pannier.get(idForma).get(4));
							int prix = Integer.parseInt(pannier.get(idForma).get(3));
							int resultat = quantity*prix ;
							pannier.get(idForma).set(5, String.valueOf(resultat));
						}
						else System.out.println("l'id saisi ne correspond pas à une formation");
							System.out.println(" ");
						break;
						
				
				case 4 : 
						System.out.println("Saisissez l'id de la formation que vous voulez supprimer : " );
						int idDell= scan.nextInt();		
						if(formation.get(idDell)!= null) {
							// Permet de supprimer la quantité 
							int qte = Integer.parseInt(pannier.get(idDell).get(4));
								--qte;		
								pannier.get(idDell).set(4, String.valueOf(qte));
								
							//calcule le résultat de chaque ligne
							int quantity = Integer.parseInt(pannier.get(idDell).get(4));
							int prix = Integer.parseInt(pannier.get(idDell).get(3));
							int resultat = quantity*prix ;
							pannier.get(idDell).set(5, String.valueOf(resultat));
						}
						else System.out.println("l'id saisi ne correspond pas à une formation");
							System.out.println(" ");
						break;
						
						//Validation du panier et remise à 0 du panier et affichage des futures formation
						case 5 :
						if (total ()>0) {
							System.out.println("");
							seePannier();
							System.out.println("Valider votre panier "+name+" O/N");
							String reponse = scan.next().toUpperCase();
							if (reponse.equals("O")) {
								pannier.clear();
								System.out.println("Votre commande à bien été valider "+name+" !");
								System.out.println("Merci");
								System.out.println("");
								futurFormations();
							} else if (reponse.equals("N")) {
								System.out.println("Merci de votre visite "+name+" !");
							}
						}else {
							System.out.println("Votre pannier est vide "+name);
							System.out.println(" ");
							}
						break;
				
				case 6 : 
						System.out.println("Au revoir "+name);
						break;
				
				default : System.out.println("mauvaise saisie " +name);
			}			
		}
	}	
}
