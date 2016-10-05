package com.ian.dp.memento;

public class TVDisplay {

	private int currentChannel;
	private int previousChannel;
	
	public Memento createMemento() {
		return new Memento(currentChannel,previousChannel);
	}
	
	/**
	 * 回看方法，将状态回执
	 * @param memento
	 */
	public void back(Memento memento){
		this.currentChannel = memento.getCurrentChannel();
		this.previousChannel = memento.getPreviousChannel();
		System.out.println("回看");
	}
	
	/**
	 * 初始化状态
	 */
	public void init(){
		this.currentChannel = 0;
		this.previousChannel = this.currentChannel;
	}
	
	/**
	 * 向上换台
	 */
	public void turnUp(){
		this.previousChannel = this.currentChannel++;
	}
	
	/**
	 * 向下换台
	 */
	public void turnDown(){
		this.previousChannel = this.currentChannel--;
	}
	
	/**
	 * 关闭电视机
	 */
	public void shutDown(){
		init();
	}
	
	/**
	 * 显示当前状态
	 */
	public void displayChannel(){
		System.out.println("当前的频道是：" + currentChannel);
		System.out.println("前一个频道是：" + previousChannel);
	}
	
}
