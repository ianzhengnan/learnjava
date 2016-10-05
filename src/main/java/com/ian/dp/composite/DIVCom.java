package com.ian.dp.composite;

import java.util.ArrayList;
import java.util.List;

public class DIVCom implements HTMLComponent{

	private List<HTMLComponent> coms = new ArrayList<>();
	private String name;

	public DIVCom(String name) {
		this.name = name;
	}
	
	public List<HTMLComponent> getComs() {
		return coms;
	}

	public void setComs(List<HTMLComponent> coms) {
		this.coms = coms;
	}

	@Override
	public void add(HTMLComponent component) {
		coms.add(component);
	}

	@Override
	public void remove(HTMLComponent component) {
		coms.remove(component);
	}

	@Override
	public void display(int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print("-");
		}
		System.out.println("<div>" + name);
		for (HTMLComponent htmlComponent : coms) {
			htmlComponent.display(depth + 2);
		}
	}

	@Override
	public void addClass() {
		
	}

}
