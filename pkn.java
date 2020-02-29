import java.util.Scanner;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Random; 


public class pkn { 
	// Mo¿liwe wybory dla komputera
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
		
		// Poproœ u¿ytkownika o wybór
		System.out.println("Wybierz: papier(p), kamieñ(k), no¿yce(n)");
		while(input.hasNextInt()) {
			System.out.println("Wybierz: papier(p), kamieñ(k), no¿yce(n)");
			input.next();
		}
		String choice = input.nextLine().toLowerCase();
		while(!choice.equals("p") && !choice.equals("k") && !choice.equals("n")) {
			System.out.println("Wybierz: papier(p), kamieñ(k), no¿yce(n)");
			choice = input.nextLine().toLowerCase();
		}
		///////////////////////
		
		// Wylosuj wybór komputera
		String computer_choice = wybory[random.nextInt(wybory.length)]; 
		///////////////////////
		
		choice = choice.toLowerCase();
		computer_choice = computer_choice.toLowerCase();
		
		// Wyczyœæ ekran przed gr¹
		cls();
		///////////////////////
		
		// Mechanika gry
		//System.out.println("User: " + choice + " Computer: " + computer_choice);
		System.out.println("Wybra³eœ: " + choice);
		System.out.println("Komputer wybra³: " + computer_choice);
		System.out.println("");
		if(choice.equals(computer_choice)) {
			System.out.println("Remis");
		}else if(choice.equals("p") && computer_choice.equals("k")) {
			System.out.println("Papier zjada kamieñ, wygra³eœ");
		}else if(choice.equals("k") && computer_choice.equals("n")) {
			System.out.println("Kamieñ têpi no¿yce, wygra³eœ");
		}else if(choice.equals("n") && computer_choice.equals("p")) {
			System.out.println("No¿yce tn¹ papier, wygra³eœ");
		}else if(choice.equals("p") && computer_choice.equals("n")) {
			System.out.println("No¿yce tn¹ papier, przegra³eœ");
		}else if(choice.equals("k") && computer_choice.equals("p")) {
			System.out.println("Papier zjada kamieñ, przegra³eœ");
		}else if(choice.equals("n") && computer_choice.equals("k")) {
			System.out.println("No¿yce tn¹ papier, przegra³eœ");
		}
		///////////////////////
		
	}
	public static void cls() throws InterruptedException, IOException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}