package ginRummy;

import java.util.Random;

public class Deck {	
	
	private Card[] deck = new Card[52];
	public int cardsInPlay = 0;
	
	Deck(){
		int i = 0;
		for(Rank r : Rank.values()){
			for(Suit s : Suit.values()){
				deck[i++] = (new Card(r,s));
			}
		}
	}
	
	public Card[] getDeck(){
		return this.deck;
	}
	
	public Card[] getStartingHand(){
		Card[] startingHand = new Card[11];
		for(int i=0; i<10; i++){
			startingHand[i] = deck[i];
			deck[i].setInPlay(true);
		}
		this.cardsInPlay = 10;
		return startingHand;
	}
	
	public Card getTopCard(){
		this.deck[cardsInPlay].setInPlay(true);
		return this.deck[cardsInPlay++];
	}
	
	public void shuffle(){
		Random randomGenerator = new Random();
		for(int i=0; i<300; i++){
			int switch1 = randomGenerator.nextInt(25);
			int switch2 = randomGenerator.nextInt(25) + 26;
			Card placeHolder;
			
			placeHolder = this.deck[switch1];
			this.deck[switch1] = this.deck[switch2];
			this.deck[switch2] = placeHolder;
		}
	}
	
	public void printDeck(){
		String isInPlay = "";
		for(int i=0; i < this.deck.length; i++){
			if(deck[i].getInPlay()) {isInPlay = "in play";}
			else{isInPlay = "not in play";}
			
			System.out.println("Card: " + this.deck[i].getRank() + " of " 
					+ this.deck[i].getSuit() + " is " + isInPlay); 
		}
	}
}
