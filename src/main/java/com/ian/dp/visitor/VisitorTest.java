package com.ian.dp.visitor;

public class VisitorTest {

	public static void main(String[] args) {
		ObjectStructure os = new ObjectStructure();
		
		Man man = new Man();
		Woman woman = new Woman();
		
		os.attach(man);
		os.attach(woman);
		
		Success success = new Success();
		os.display(success);
		
		Fail fail = new Fail();
		os.display(fail);
		
		Love love = new Love();
		os.display(love);
		
		//以下为扩展部分，只需要新增visitor和改这里
		Merriage merriage = new Merriage();
		os.display(merriage);
	}
}
