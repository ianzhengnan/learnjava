package ian.oo.exercise.showhand;

public class ShowHand {

	private Player[] players = new Player[5];
	private Card[] cards = new Card[28];

	// getters and setters




	// create 28 cards for play
	public void createCards(){

		// create a non-sequence 28 cards
		cards[0] = new Card(CardType.SPADE, "A");
		cards[1] = new Card(CardType.SPADE, "10");
		cards[2] = new Card(CardType.HEART, "J");
		cards[3] = new Card(CardType.CLUB, "K");
		cards[4] = new Card(CardType.DIAMOND, "Q");

	}
	// get the top card of all cards and pop it from cards pool
	private Card getOneCard(){
		Card top = cards[cards.length - 1];
		
		return top;
	}

	// setup showhand
	public void setup(){
		players[0] = new Player("郑楠", 1000, 0);
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


	public static void main(String[] args){

		ShowHand sh = new ShowHand();
		sh.setup();
		sh.sendCard();
		sh.showPlayers();

	}

}