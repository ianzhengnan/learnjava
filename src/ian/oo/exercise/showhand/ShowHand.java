package ian.oo.exercise.showhand;

import java.util.Random;
import java.util.Scanner;

public class ShowHand {

	private Player[] players = new Player[5];
	private Card[] cards = new Card[28];
	private int current = 27;
	// getters and setters



	// create 28 cards for play
	public void createCards(){

		// create a non-sequence 28 cards
		Random r = new Random();

		CardType[] ct = new CardType[]{CardType.SPADE, CardType.HEART, CardType.CLUB, CardType.DIAMOND};
		String[] ids = new String[]{"8", "9", "10", "J", "Q", "K", "A"};

		for(int i = 0; i < ct.length; i++ ){
			for(int j = 0; j < ids.length; j++){

				int index = 0;
				while(1 < 2){
					index = r.nextInt(28);
					if (cards[index] == null) {
						break;
					}
				}
				cards[index] = new Card(ct[i], ids[j]);
			}
		}
	}
	// get the top card of all cards and pop it from cards pool
	private Card getOneCard(){
		Card top = null;
		if (current >= 0) {
			top = cards[current--];
		}
		return top;
	}

	// setup showhand
	public void setup(){

		players[0] = new Player("小郑", 1000, 0);
		players[1] = new Player("小明", 1000, 1);
		players[2] = new Player("小张", 1000, 2);
		players[3] = new Player("小李", 1000, 3);
		players[4] = new Player("小杨", 1000, 4);

		for (int i = 0; i < players.length ; i++) {
			players[i].setPs(PlayerStatus.PLAYING);
		}
		createCards();

	}
	// send a card to every players
	public void sendCard(){

		for(int i = 0; i < 5; i ++){
			if (players[i].getPs() == PlayerStatus.WAITING) {
				continue;
			}

			for (int j = 0; j < 5 ; j++) {

				if (players[i].getCard(j) == null) {
					players[i].setCard(j, getOneCard());
					break;
				}
			}
		}
	}

	private void showCards(Card[] cards){
		for (int i = 0; i < 5 ; i++) {
			if (cards[i] != null) {
				System.out.println(cards[i].getCt().getName() + cards[i].getCardId());
			}
		}
	}

	public void showPlayers(){

		for(int i = 0; i < 5; i ++){
			showCards(players[i].getCards());
		}
	}


	public void showStatus(){

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		for(int i = 0; i < 5; i++){
			System.out.print(players[i].getName() + "----->" + 
				"剩余金额：" + players[i].getMoney() + 
				"  当前下注：" + players[i].getCurrent());
			if (players[i].getPs() == PlayerStatus.WAITING) {
				System.out.print("  状态：退出");
			}else{
				System.out.print("  状态：正在玩");
			}
			System.out.println();
			
		}

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		for(int i = 0; i < 5; i++){
			System.out.print(players[i].getName() + "----->" + "当前牌面：");
			for(int j = 0; j < players[i].getCards().length; j++){
				if (players[i].getCards()[j] != null) {
					Card card = players[i].getCards()[j];
					System.out.print(card.getCt().getName() + card.getCardId() + "  ");
				}
			}
			System.out.println();
		}

	}

	public static void help(){
		System.out.println("Usage:");
		System.out.println("new--->start a new round.");
		System.out.println("bet--->bet the game.");
		System.out.println("send-->send cards.");
		System.out.println("show-->show status.");
		System.out.println("quit-->quit the game.");
	}

	public static void main(String[] args){

		ShowHand sh = new ShowHand();
		sh.setup();

		Scanner sc = new Scanner(System.in);
		Scanner scBet = new Scanner(System.in);

		System.out.print(">>>");
		String cmd = "";
		while(sc.hasNextLine()){
			
			cmd = sc.nextLine();
			switch(cmd){

				case "show":
					sh.showStatus();
					System.out.print(">>>");
					break;
				case "quit":
					return;
				case "send":
					sh.sendCard();
					System.out.println("Cards are sent.");
					System.out.print(">>>");
					break;
				case "new":
					sh = new ShowHand();
					sh.setup();
					System.out.println("This is a new round. Please enjoy!");
					System.out.print(">>>");
					break;
				case "bet":
					int bet = 0;
					for (int i = 0; i < 5 ; i++) {
						System.out.print(sh.players[i].getName() + ">>>");
						bet = scBet.nextInt();
						if (bet <= 0) {
							sh.players[i].quit();
						}
						sh.players[i].follow(bet);
					}
					System.out.print(">>>");
					break;
				case "help":
					help();

				default:
					System.out.print(">>>");
			}


		}



	}

}