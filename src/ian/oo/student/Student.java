package ian.oo.student;

import ian.oo.person.Person;
import ian.oo.school.School;

public class Student extends Person{

	private String grade, classNo;
	private School scl;

	public Student(){
		System.out.println("I'm a student.");
	}

	public Student(String name, String gender, int age){
		super(name, gender, age);
	}

	public Student(String name, String gender, int age, String phone, String address, String email, String grade, String classNo){

		super(name, gender, age, phone, address, email);
		this.grade = grade;
		this.classNo = classNo;
	}



	// setters and getters
	public String getGrade(){
		return this.grade;
	}
	public void setGrade(String grade){
		this.grade = grade;
	}

	public String getClassNo(){
		return this.classNo;
	}
	public void setClassNo(String classNo){
		this.classNo = classNo;
	}

	public School getScl(){
		return this.scl;
	}
	public void setScl(School scl){
		this.scl = scl;
	}


	// behaviors

	public void study(){
		System.out.println(this.name + " is studying in " + this.scl.getName());
	}



}