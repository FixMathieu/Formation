import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Formation {
	protected static Map <Integer,ArrayList<String>> formation = new HashMap<>();
	public static void main(String[] args) {
		listeFormations();
		displayFormations();
		
	}
	
	
	
	public static void displayFormations() {
		System.out.println("         Bonjour et bienvenu dans mon application FullTrainings");
		System.out.println("Nous allons vous proposer une liste de formation actuellement disponible");
		System.out.println("-------------------------------------------------------------------------");
		System.out.printf("%-14s | %-8s | %-36s |%-4s |\n","COURS", "NB/JOURS", "DESCRIPTION", " PRIX");
		System.out.println("---------------|----------|--------------------------------------|------|");
		formation.entrySet()
		.stream()
		.forEach(e -> System.out.printf("%-14s | %-8s | %-36s | %-4s |\n",e.getValue().get(0),e.getValue().get(1),e.getValue().get(2),e.getValue().get(3)));	
		System.out.println("-------------------------------------------------------------------------");
	}
	

	private static void listeFormations() {
	formation.put(1,new ArrayList<String>());
	formation.get(1).add("Java"); formation.get(1).add("20");formation.get(1).add("Java SE 8 : Syntaxe & Poo");formation.get(1).add("3000");
	formation.put(2,new ArrayList<String>());
	formation.get(2).add("Java avancé"); formation.get(2).add("20");formation.get(2).add("Exceptions, fichiers,Jdbc, thread...");formation.get(2).add("5000");
	formation.put(3,new ArrayList<String>());
	formation.get(3).add("Spring"); formation.get(3).add("20");formation.get(3).add("Spring Core/Mvc/Security");formation.get(3).add("5000");
	formation.put(4,new ArrayList<String>());
	formation.get(4).add("Php frameworks"); formation.get(4).add("15");formation.get(4).add("Symphony");formation.get(4).add("2500");
	formation.put(5,new ArrayList<String>());
	formation.get(5).add("C#"); formation.get(5).add("20");formation.get(5).add("DotNet Core");formation.get(5).add("5000");
	}
	
}
