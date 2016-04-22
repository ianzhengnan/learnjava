package ian.oo.school;

/**
*	Description: 
*	<br>Website: <a href="#">This is a school class.</a>
*	<br>Copyright (C), 2016-2018, Ian.Zheng
*	<br>This class is about school
*	<br>Program name:
*	<br>Name:
*	@author Ian.Zheng flks555@163.com
*	@version 1.0.0
*
*/


public class School{

	private String name, address, phone, website, email;

	private School(){
		System.out.println("This is a school!");
	}

	public School(String name, String address){
		this.name = name;
		this.address = address;
	}

	public School(String name, String address, String phone, String website, String email){
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.email = email;
	}

	{
		this.name = "";
		this.address = "";
		this.phone = "";
		this.website = "";
		this.email = "flks@yahoo.com";
	}


	// get setter and getter
	/**
	*	This is a method of school opening.
	*	
	*	@return void
	*/
	public String getName(){
		return this.name;
	}
	/**
	*	This is a method of school opening.
	*	@param name The school's name
	*	
	*/
	public void setName(String name){
		this.name = name;
	}

	public String getWebsite(){
		return this.website;
	}
	public void setWebsite(String website){
		this.website = website;
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

	/**
	*	This is a method of school opening.
	*	
	*	
	*/
	public void open(){
		System.out.println("School " + this.name + " is opening.");
	}
	/**
	*	This is a method of school closing.
	*	
	*	
	*/
	public void close(){
		System.out.println("School " + this.name + " is closing.");
	}


}