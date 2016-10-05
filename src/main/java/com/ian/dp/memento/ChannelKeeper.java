package com.ian.dp.memento;

/**
 * 用来保存Memento 对象，以达到保存状态的目的
 * @author zhengnan
 *
 */
public class ChannelKeeper {

	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	
}
