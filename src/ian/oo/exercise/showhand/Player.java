package ian.oo.exercise.showhand;

public class Player {

	private String name;
	private PlayerStatus ps;
	private Card[] cards = new Card[5];
	private int money;
	private int current;

	public Player(){

	}

	public Player(String name, int money){
		this.name = name;
		this.ps = PlayerStatus.WAITING;
		this.money = money;
		this.current = 0;
	}


	// getters and setters
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	public PlayerStatus getPs(){
		return this.ps;
	}
	public void setPs(PlayerStatus ps){
		this.ps = ps;
	}

	public Card[] getCards(){
		return this.cards;
	}
	public void setCards(){
		this.cards = cards;
	}

	public int getMoney(){
		return this.money;
	}
	public void setMoney(int money){
		this.money = money;
	}

	// behaviors

	public void quit(){
		this.ps = PlayerStatus.WAITING;
		this.money -= this.current;
		this.current = 0;
	}

	public void follow(int pay){
		this.current += pay;
		this.money -= this.current;
	}

	public void beyond(int pay){
		this.follow(pay);
	}

	public void showhand(){
		this.current = this.money;
		this.money = 0;
	}

}