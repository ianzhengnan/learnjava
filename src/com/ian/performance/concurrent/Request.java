package com.ian.performance.concurrent;

public class Request {

	private String name;
	
	public Request(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "[ Request " + name + " ]";
	}
}
