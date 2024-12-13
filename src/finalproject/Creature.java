package finalproject;

public abstract class Creature {
	
	String type;
	
	String name;
	
	int age;
	
	public Creature(String type, String name, int age) {
		this.type = type;
		this.name = name;
		this.age = age;
	}
	
	public String getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	abstract public void displayInfo();
}
