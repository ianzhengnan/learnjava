package com.ian.dp.prototype;

public class ResumeTest {

	public static void main(String[] args) throws Exception {
		Resume a = new Resume("大鸟");
		a.setPersonalInfo("男", 29);
		a.setWorkingExperience("1998-2004", "xx公司");
		
		Resume b = (Resume)a.clone();
		b.setWorkingExperience("2004-2006", "x1公司");
		
		Resume c = (Resume)a.clone();
		c.setPersonalInfo("女", 21);
		
		a.display();
		b.display();
		c.display();
		
	}
}
