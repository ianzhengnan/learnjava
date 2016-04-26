package ian.oo.exercise.abstracts;

public class Car extends Vehicle {

	public Car(String name){
		this.name = name;
	}
	void func(){
		System.out.println("Car can carry people");
	}

	public String move(){
		return this.name + " is moving.";
	}

	public static void main(String[] args){

		Car car = new Car("Ford");
		car.func();
		System.out.println(car.move());
	}

}