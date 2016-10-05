package com.ian.dp.composite;

public interface HTMLComponent {

	/**
	 * 增加子元素
	 * @param component
	 */
	void add(HTMLComponent component);
	
	/**
	 * 删除子元素
	 * @param component
	 */
	void remove(HTMLComponent component);
	
	/**
	 * 显示组件
	 * @param depth
	 */
	void display(int depth);
	
	
	/**
	 * 给html元素增加css类
	 */
	void addClass();
	
}
