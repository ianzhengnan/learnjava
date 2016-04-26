package ian.oo.exercise.showhand;

public class Card {

	private CardType ct;
	private String cardId;

	public Card(CardType ct, String cardId){
		this.ct = ct;
		this.cardId = cardId;
	}

	// getters and setters
	public void setCt(CardType ct){
		this.ct = ct;
	}
	public CardType getCt(){
		return this.ct;
	}

	public void setCardId(String cardId){
		this.cardId = cardId;
	}
	public String getCardId(){
		return this.cardId;
	}

}