import java.util.Scanner;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Random; 


public class helloworld { 
	// Możliwe wybory dla komputera
	public static String[] wybory = {"PAPIER", "KAMIEŃ","NOŻYCE"};
	///////////////////////
	
	public static void main(String[] args) throws InterruptedException, IOException 
	{ 
		// Ustaw seed losowania
		LocalTime localTime = LocalTime.now();
		int time = localTime.getHour() + localTime.getMinute() + localTime.getSecond();
		Scanner input = new Scanner(System.in);
		Random random = new Random(time); 
		///////////////////////
		
		// Popros użytkownika o wybór
		System.out.println("Wybierz: papier, kamień, nożyce");
		while(input.hasNextInt()) {
			System.out.println("Wybierz: papier, kamień, nożyce");
			input.next();
		}
		String choice = input.nextLine().toUpperCase();
		while(!choice.equals("PAPIER") && !choice.equals("KAMIEŃ") && !choice.equals("NOŻYCE")) {
			System.out.println("Wybierz: papier, kamień, nożyce");
			choice = input.nextLine().toUpperCase();
		}
		///////////////////////
		
		// Wylosuj wybór komputera
		String computer_choice = wybory[random.nextInt(wybory.length)]; 
		///////////////////////
		
		choice = choice.toLowerCase();
		computer_choice = computer_choice.toLowerCase();
		
		// Wyczyść ekran przed grą
		cls();
		///////////////////////
		
		// Mechanika gry
		//System.out.println("User: " + choice + " Computer: " + computer_choice);
		System.out.println("Wybrałeś: " + choice);
		System.out.println("Komputer wybrał: " + computer_choice);
		System.out.println("");
		if(choice.equals(computer_choice)) {
			System.out.println("Remis");
		}else if(choice.equals("papier") && computer_choice.equals("kamień")) {
			System.out.println("Papier zjada kamień, wygrałeś");
		}else if(choice.equals("kamień") && computer_choice.equals("nożyce")) {
			System.out.println("Kamień tępi nożyce, wygrałeś");
		}else if(choice.equals("nożyce") && computer_choice.equals("papier")) {
			System.out.println("Nożyce tną papier, wygrałeś");
		}else if(choice.equals("papier") && computer_choice.equals("nożyce")) {
			System.out.println("Nożyce tną papier, przegrałeś");
		}else if(choice.equals("kamień") && computer_choice.equals("papier")) {
			System.out.println("Papier zjada kamień, przegrałeś");
		}else if(choice.equals("nożyce") && computer_choice.equals("kamień")) {
			System.out.println("Nożyce tną papier, przegrałeś");
		}
		///////////////////////
		
	}
	public static void cls() throws InterruptedException, IOException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}