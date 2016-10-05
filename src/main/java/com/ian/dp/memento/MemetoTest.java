package com.ian.dp.memento;

public class MemetoTest {

	public static void main(String[] args) {
		TVDisplay tvd = new TVDisplay();
		
		ChannelKeeper ck = new ChannelKeeper();
		
		//看电视，调台
		tvd.init();
		tvd.turnUp();
		tvd.turnUp();
		tvd.turnUp();
		tvd.turnUp();
		tvd.turnDown();
		
		tvd.displayChannel();
		//保存状态
		ck.setMemento(tvd.createMemento());
		
		tvd.init();
		tvd.displayChannel();
		//回执状态
		tvd.back(ck.getMemento());
		tvd.displayChannel();
	
	}
	
	
	
}
