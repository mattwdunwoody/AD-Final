package finalproject;

public class Dragon extends Creature implements Ability {
	
	private int fire_power;

	public Dragon(String type, String name, int age, int fire_power) {
		super(type, name, age);
		this.fire_power = fire_power;
	}
	
	public int getFirePower() {
		return fire_power;
	}

	@Override
	public void useAbility() {
		System.out.println(name + " breathes fire with power level " + fire_power + "!");
		
	}

	@Override
	public void displayInfo() {
		System.out.println("Name: " + name + " | Type: " + type + "\nAge: " + age + "\nFirepower: " + fire_power);
		
	}

}
