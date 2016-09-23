package com.ian.dp.decorator;

public class DecoratorTest {

	public static void main(String[] args) {
		Person xiaocai = new Person("小菜");
		
		Decorator tshirts = new TShirts();
		Decorator bigTrouser = new BigTrouser();
		Decorator sneakerShoes = new SneakerShoes();
		
		tshirts.decorate(xiaocai);
		bigTrouser.decorate(tshirts);
		sneakerShoes.decorate(bigTrouser);
		
		sneakerShoes.show();
		
	}
}
