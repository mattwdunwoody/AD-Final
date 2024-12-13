package finalproject;

import java.util.Scanner;

public class FantasyCreatureManagementSystem {

	public static void main(String[] args) {
		
		boolean running = true;
		
		CreatureManager cm = new CreatureManager();
		Scanner scanner = new Scanner(System.in);
		
		while(running) {
			
			System.out.println("--- Creature Management ---");
			System.out.println("1. Add Creature");
			System.out.println("2. Remove Creature");
			System.out.println("3. Display Creatures");
			System.out.println("4. Filter by type");
			System.out.println("5. Show Statistics");
			System.out.println("6. Save Data");
			System.out.println("7. Load Data");
			System.out.println("8. Exit");
			System.out.println("Choose an option: ");
			
			try {
				int user_input = Integer.parseInt(scanner.nextLine());
				
				switch (user_input) {
				case 1:
					//add creature
					cm.addCreature();
					break;
				case 2:
					//remove creature
					cm.removeCreature();
					break;
				case 3:
					//display creatures
					cm.displayCreatures();
					break;
				case 4:
					//filter
					cm.filterCreatures();
					break;
				case 5:
					//stats
					cm.showCreatureStats();
					break;
				case 6:
					//save
					cm.saveCreatureData();
					break;
				case 7:
					//load
					cm.loadCreatureData();
					break;
				case 8:
					//exit
					scanner.close();
					running = false;
					break;
				default:
					System.out.println("Error! Please enter a number listed above.");	
					break;
				}
			}
			catch(Exception e) {
				System.out.println(e.toString());
				System.out.println("Please check your input and try again.");
			}
			
			
		}
	}
	
}
