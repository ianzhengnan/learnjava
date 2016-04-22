package ian.oo.person;

public class Person {

	protected String name, gender, phone, address, email;
	protected int age;

	public Person(){
		System.out.println("I'm a person");
	}

	public Person(String name, String gender, int age){
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public Person(String name, String gender, int age, String phone, String address, String email){
		this(name, gender, age);
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	// setters and getters

	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getGender(){
		return this.gender;
	}
	public void setGender(String gender){
		this.gender = gender;
	}

	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		this.age = age;
	}

	public String getAddress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address = address;
	}

	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}

	// behaviors
	public void eat(){
		System.out.println(this.name + " is eating.");
	}

	public void drink(){
		System.out.println(this.name + " is drinking.");
	}

	public void sleep(){
		System.out.println(this.name + " is sleeping.");
	}

	public void play(){
		System.out.println(this.name + " is playing.");
	}


}
