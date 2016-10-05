package com.ian.dp.memento;

public class Memento {

	private int currentChannel;
	private int previousChannel;
	
	public Memento(int curChannel, int preChannel){
		this.currentChannel = curChannel;
		this.previousChannel = preChannel;
	}
	
	public int getCurrentChannel() {
		return currentChannel;
	}
	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}
	public int getPreviousChannel() {
		return previousChannel;
	}
	public void setPreviousChannel(int previousChannel) {
		this.previousChannel = previousChannel;
	}
	
	
	
}
