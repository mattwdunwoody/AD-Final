package finalproject;

public class Unicorn extends Creature implements Ability {
	
	private String horn_color;

	public Unicorn(String type, String name, int age, String horn_color) {
		super(type, name, age);
		this.horn_color = horn_color;
	}
	
	public String getHornColor() {
		return horn_color;
	}

	@Override
	public void useAbility() {
		System.out.println(name + " heals all damage!");
		
	}

	@Override
	public void displayInfo() {
		System.out.println("Name: " + name + " | Type: " + type + "\nAge: " + age + "\nHorn color: " + horn_color);
		
	}

}
