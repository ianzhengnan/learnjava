package ian.oo.exercise.showhand;

public class Player {

	private String name;
	private PlayerStatus ps;
	private Card[] cards = new Card[5];
	private int money;
	private int current;
	private int position;

	public Player(){

	}

	public Player(String name, int money, int position){
		this.name = name;
		this.ps = PlayerStatus.WAITING;
		this.money = money;
		this.current = 0;
		this.position = position;
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

	public Card getCard(int i){
		return this.cards[i];
	}
	public void setCard(int i, Card card){
		this.cards[i] = card;
	}

	public int getMoney(){
		return this.money;
	}
	public void setMoney(int money){
		this.money = money;
	}

	public int getCurrent(){
		return this.current;
	}
	public void setCurrent(int current){
		this.current = current;
	}

	public int getPosition(){
		return this.position;
	}
	public void setPosition(int position){
		this.position = position;
	}

	// behaviors

	public void quit(){
		this.ps = PlayerStatus.WAITING;
		this.money -= this.current;
		this.current = 0;
	}

	public void follow(int pay){
		if (this.ps == PlayerStatus.WAITING) {
			return;
		}
		if ((this.current + pay) > this.money) {
			System.out.println("You don't have enough money to follow!");
			// System.our.println(">>>");
			return;
		}
		this.current += pay;
		this.money -= this.current;
	}

	public void beyond(int pay){
		if (this.ps == PlayerStatus.WAITING) {
			return;
		}
		if ((this.current + pay) > this.money) {
			System.out.println("You don't have enough money to beyond!");
			// System.our.println(">>>");
			return;
		}
		this.follow(pay);
	}

	public void showhand(){
		if (this.ps == PlayerStatus.WAITING) {
			return;
		}
		this.current = this.money;
		this.money = 0;
	}

}