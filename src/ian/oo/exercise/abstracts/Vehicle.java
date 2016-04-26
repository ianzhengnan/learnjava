package ian.oo.exercise.abstracts;

public abstract class Vehicle {

	public String name;
	
	abstract void func();
	
	String move(){
		return "The vehicle is moving.";
	}
}