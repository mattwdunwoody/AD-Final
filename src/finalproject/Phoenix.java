package finalproject;

public class Phoenix extends Creature implements Ability  {
	
	private int wingspan_inches;

	public Phoenix(String type, String name, int age, int wingspan_inches) {
		super(type, name, age);
		this.wingspan_inches = wingspan_inches;
	}
	
	public int getWingspan() {
		return wingspan_inches;
	}

	@Override
	public void useAbility() {
		System.out.println(name + " is reborn!");
		
	}

	@Override
	public void displayInfo() {
		System.out.println("Name: " + name + " | Type: " + type + "\nAge: " + age + "\nWingspan: " + wingspan_inches);
		
	}

}
