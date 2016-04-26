package ian.oo.exercise.showhand;

public enum CardType{

	SPADE("黑桃"), HEART("红心"), DIAMOND("方块"), CLUB("梅花");

	private String name;

	private CardType(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}


}