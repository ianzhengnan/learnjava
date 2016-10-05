package com.ian.dp.composite;

//import java.util.ArrayList;
//import java.util.List;

public class PCom implements HTMLComponent{

//	private List<HTMLComponent> coms = new ArrayList<>();
	private String name;
	
	public PCom(String name) {
		this.name = name;
	}
	
	@Override
	public void add(HTMLComponent component) {
		
	}

	@Override
	public void remove(HTMLComponent component) {
		
	}

	@Override
	public void display(int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print("-");
		}
		System.out.println("<p>" + name);
	}

	@Override
	public void addClass() {
		
	}

}
