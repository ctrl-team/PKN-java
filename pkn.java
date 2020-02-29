import java.util.Scanner;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Random; 


public class pkn { 
	// Mo�liwe wybory dla komputera
	public static String[] wybory = {"p", "k","n"};
	///////////////////////
	
	public static void main(String[] args) throws InterruptedException, IOException 
	{ 
		// Ustaw seed losowania
		LocalTime localTime = LocalTime.now();
		int time = localTime.getHour() + localTime.getMinute() + localTime.getSecond();
		Scanner input = new Scanner(System.in);
		Random random = new Random(time); 
		///////////////////////
		
		// Popro� u�ytkownika o wyb�r
		System.out.println("Wybierz: papier(p), kamie�(k), no�yce(n)");
		while(input.hasNextInt()) {
			System.out.println("Wybierz: papier(p), kamie�(k), no�yce(n)");
			input.next();
		}
		String choice = input.nextLine().toLowerCase();
		while(!choice.equals("p") && !choice.equals("k") && !choice.equals("n")) {
			System.out.println("Wybierz: papier(p), kamie�(k), no�yce(n)");
			choice = input.nextLine().toLowerCase();
		}
		///////////////////////
		
		// Wylosuj wyb�r komputera
		String computer_choice = wybory[random.nextInt(wybory.length)]; 
		///////////////////////
		
		choice = choice.toLowerCase();
		computer_choice = computer_choice.toLowerCase();
		
		// Wyczy�� ekran przed gr�
		cls();
		///////////////////////
		
		// Mechanika gry
		//System.out.println("User: " + choice + " Computer: " + computer_choice);
		System.out.println("Wybra�e�: " + choice);
		System.out.println("Komputer wybra�: " + computer_choice);
		System.out.println("");
		if(choice.equals(computer_choice)) {
			System.out.println("Remis");
		}else if(choice.equals("p") && computer_choice.equals("k")) {
			System.out.println("Papier zjada kamie�, wygra�e�");
		}else if(choice.equals("k") && computer_choice.equals("n")) {
			System.out.println("Kamie� t�pi no�yce, wygra�e�");
		}else if(choice.equals("n") && computer_choice.equals("p")) {
			System.out.println("No�yce tn� papier, wygra�e�");
		}else if(choice.equals("p") && computer_choice.equals("n")) {
			System.out.println("No�yce tn� papier, przegra�e�");
		}else if(choice.equals("k") && computer_choice.equals("p")) {
			System.out.println("Papier zjada kamie�, przegra�e�");
		}else if(choice.equals("n") && computer_choice.equals("k")) {
			System.out.println("No�yce tn� papier, przegra�e�");
		}
		///////////////////////
		
	}
	public static void cls() throws InterruptedException, IOException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}