package finalproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import finalproject.FileHandler.*;

public class CreatureManager {
	
	ArrayList<Creature> creatures = new ArrayList<>();
	
	Scanner cm_scanner = new Scanner(System.in);

	// add creature
	void addCreature() {
		
		System.out.println("Enter type (Dragon/Unicorn/Phoenix): ");
		String creature_type = cm_scanner.nextLine();
		
		if(creature_type.equals("Dragon") || creature_type.equals("Unicorn") || creature_type.equals("Phoenix")) {
			
			System.out.println("Enter name: ");
			String creature_name = cm_scanner.nextLine();
			
			System.out.println("Enter age: ");
			int creature_age = Integer.parseInt(cm_scanner.nextLine());
			
			switch(creature_type) {
			case "Dragon":
				System.out.println("Enter fire power: ");
				int dragon_firepower = Integer.parseInt(cm_scanner.nextLine());
				//cm_scanner.nextLine();
				Dragon dragon = new Dragon(creature_type, creature_name, creature_age, dragon_firepower);
				creatures.add(dragon);
				break;
			case "Unicorn":
				//make a unicorn
				System.out.println("Enter horn color: ");
				String unicorn_horn_color = cm_scanner.nextLine();
				Unicorn unicorn = new Unicorn(creature_type, creature_name, creature_age, unicorn_horn_color);
				creatures.add(unicorn);
				break;
			case "Phoenix":
				//make a phoenix
				System.out.println("Enter wingspan in inches: ");
				int phoenix_wingspan = Integer.parseInt(cm_scanner.nextLine());
				Phoenix phoenix = new Phoenix(creature_type, creature_name, creature_age, phoenix_wingspan);
				creatures.add(phoenix);
				break;
			}
			System.out.println("Creature successfully added.");
		}
		else {
			System.out.println("Creature type not recognized!");
		}
		
	}
	
	// remove creature
	void removeCreature() {
		System.out.println("Enter the name of creature to remove: ");
		String remove_creature_input = cm_scanner.nextLine();
		
		for(Creature creature : creatures) {
			if(remove_creature_input.equals(creature.getName())) {
				creatures.remove(creature);
				System.out.println("Creature removed successfully.");
				break;
			}
			else {
				System.out.println("Could not find the creature by specified name: " + remove_creature_input);
			}
		}	
		
	}
	
	// display creatures
	void displayCreatures() {
		if(creatures.size() > 0) {
			for(Creature creature : creatures) {
				creature.displayInfo();
				System.out.println("-----------");
			}
		}
		else {
			System.out.println("No creatures to display.");
		}
		
	}
	
	// filter by type
	void filterCreatures() {
		
		if(creatures.size() > 0) {
		
			ArrayList<Creature> dragons = new ArrayList<>();
			ArrayList<Creature> unicorns = new ArrayList<>();
			ArrayList<Creature> phoenixes = new ArrayList<>();
			
			for(Creature creature : creatures) {
				if(creature.getType().equals("Dragon")) {
					dragons.add(creature);
				}
				else if(creature.getType().equals("Unicorn")) {
					unicorns.add(creature);
				}
				else if(creature.getType().equals("Phoenix")) {
					phoenixes.add(creature);
				}
				else {
					System.out.print("Invalid creature type detected!");
				}
			}
			if(dragons.size() > 0) {
				System.out.println(" --- Dragons ---");
				for(Creature dragon : dragons) {
					dragon.displayInfo();
					System.out.println("------------");
				}
			}
			if(unicorns.size() > 0) {
				System.out.println(" --- Unicorns ---");
				for(Creature unicorn : unicorns) {
					unicorn.displayInfo();
				}
			}
			if(phoenixes.size() > 0) {
				System.out.println(" --- Phoenixes --- ");
				for(Creature phoenix : phoenixes) {
					phoenix.displayInfo();
				}
			}
			
		}
		else {
			System.out.println("No creatures to filter.");
		}
	}
	
	// show stats
	void showCreatureStats() {
		
		if(creatures.size() > 0) {
			int total_age = 0;
			float average_age = 0;
			int count_dragons = 0;
			int count_unicorns = 0;
			int count_phoenixes = 0;
			
			for(Creature creature : creatures) {
				total_age += creature.getAge();
				switch (creature.getType()) {
					case "Dragon":
						count_dragons += 1;
						break;
					case "Unicorn":
						count_unicorns += 1;
						break;
					case "Phoenix":
						count_phoenixes += 1;
						break;
				}
			}
			average_age = total_age / creatures.size();
			
			System.out.println("Average age: " + average_age);
			System.out.println("Creature type counts: \nDragons: " + count_dragons + "\nUnicorns: " + count_unicorns + "\nPhoenixes: " + count_phoenixes);
		}
		
		else {
			System.out.println("No creatures to give statistics for.");
		}
		
	}
	
	// save data
	void saveCreatureData() {
			
		if(creatures.size() > 0) {
			//FileHandler fh = new FileHandler();
			//fh.SaveData(creatures);
			Runnable saveRunnable = new SaveDataWorker(creatures);
			new Thread(saveRunnable).start();
		}
		else {
			System.out.println("No creatures to save.");
		}
			
	}
	
	// load data
	void loadCreatureData() throws IOException {		
		
		//FileHandler fh = new FileHandler();
		//fh.LoadData(creatures);
		Runnable loadRunnable = new LoadDataWorker(creatures);
		new Thread(loadRunnable).start();
		
	}
	
	public ArrayList<Creature> getCreatures() {
		return creatures;
	}

}
