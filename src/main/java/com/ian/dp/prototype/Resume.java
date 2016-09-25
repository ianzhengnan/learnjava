package com.ian.dp.prototype;


public class Resume implements Cloneable{

	private String name;
	private String sex;
	private int age;
	private WorkExperience work;
	
	public Resume(String name) {
		this.name = name;
		work = new WorkExperience();
	}
	
	/**
	 * 为深层复制服务的私有构造方法
	 * @param work
	 * @throws CloneNotSupportedException
	 */
	private Resume(WorkExperience work) throws CloneNotSupportedException{
		this.work = (WorkExperience)work.clone();
	}
	
	public void setWorkingExperience(String timeArea, String company){
		work.setTimeArea(timeArea);
		work.setCompany(company);
	}
	
	public void setPersonalInfo(String sex, int age){
		this.age = age;
		this.sex = sex;
	}

	public void display(){
		System.out.println(name + " " + sex + " " + age);
		System.out.println("工作经历: " + work.getTimeArea() + " " + work.getCompany());
	}
	
	/**
	 * 深层复制
	 */
	@Override
	public Object clone() throws CloneNotSupportedException{
		Resume resume = new Resume(work);
		resume.name = this.name;
		resume.age = this.age;
		resume.sex = this.sex;
		return resume;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
		
}
