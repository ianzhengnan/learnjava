package ian.oo.teacher;

import ian.oo.person.Person;

public class Teacher extends Person{

	private String grade, title;

	public Teacher(){
		System.out.println("I'm a teacher.");
	}

	public Teacher(String name, String gender, int age){
		super(name, gender, age);
	}

	public Teacher(String name, String gender, int age, String phone, String address, String email, String grade){

		super(name, gender, age, phone, address, email);
		this.grade = grade;

	}

	// setters and getters
	public String getGrade(){
		return this.grade;
	}
	public void setGrade(String grade){
		this.grade = grade;
	}

	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}


	//behaivors
	public void teach(){
		System.out.println(this.name + " is teaching.");
	}




}