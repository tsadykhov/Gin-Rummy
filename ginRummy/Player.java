package ginRummy;

import java.io.*;

public class Player {
	private String name = null;
	private Card[] myHand = new Card[11];
	private int cardCount = 0;
	private Card[][] straights = new Card[3][4];
	private Card[][] ofAKinds = new Card[3][4];
	private int straightCount = 0;
	private int ofAKindCount = 0;
	
	Player(){};
	
	Player(Card[] startingHand){
		this.myHand = startingHand;
		this.cardCount = 10;
	}
	
	public void addCard(Card card){
		if(cardCount<11){
			myHand[cardCount++] = card;
			this.clearStraights();
			this.organizeHand();
		}
	}
	
	public Card dropCard(){
		System.out.println("Please enter # of card you would like to drop: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int drop = Integer.parseInt(br.readLine())-1;
			Card temp = myHand[drop];
			myHand[drop] = myHand[10];
			myHand[10] = null;
			this.cardCount--;
			this.clearStraights();
			this.organizeHand();
			return(temp);
		}
		catch (IOException ioe) {
			return(null);
		}
	}
	
	public Card getLastCard(){
		return myHand[cardCount];
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getCardCount(){
		return this.cardCount;
	}
	
	public void printHand(){
		for(int i=0; i < this.cardCount; i++){
			System.out.println((i+1) + ": " + myHand[i].getRank() + " of " + myHand[i].getSuit());
		}
	}
	
	public void getPlayerName(){
		//  prompt the user to enter their name
		System.out.print("Enter your name: ");
	    
		//  open up standard input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//  read the username from the command-line; need to use try/catch with the
		//  readLine() method
		try {
			this.name = br.readLine();
		}
		catch (IOException ioe) {
			System.out.println("IO error trying to read your name!");
			System.exit(1);
		}
	}
	
	public void organizeHand(){
		Card temp = new Card();
		for(int i=0; i < cardCount; i++){
			for(int j = 0; j < cardCount; j++){
				if(this.myHand[i].getRank().ordinal() < this.myHand[j].getRank().ordinal()){
					temp = this.myHand[i];
					this.myHand[i] = this.myHand[j];
					this.myHand[j] = temp;
				}
				else if((this.myHand[i].getRank().ordinal() == this.myHand[j].getRank().ordinal()) 
						&& (this.myHand[i].getSuit().ordinal() < this.myHand[j].getSuit().ordinal()))
				{
					temp = this.myHand[i];
					this.myHand[i] = this.myHand[j];
					this.myHand[j] = temp;
				}
					
			}
		}
		findOfAKinds();
		findStraights();
	}
	
	public void findOfAKinds(){
		for(int i=0; i < this.cardCount; i++){
			
		}
	}
	
	public void findStraights(){
		for(int i = 0; i < (this.cardCount - 1); i++){
			this.myHand[i].setInStraight(false);
			int j = checkForNext(i+1, this.myHand[i].getSuit(), this.myHand[i].getRank());
			if(j > 0){
				int k = checkForNext(j+1, this.myHand[j].getSuit(), this.myHand[j].getRank());
				if(k > 0){
					int l = checkForNext(k+1, this.myHand[k].getSuit(), this.myHand[k].getRank());
					if(l > 0){
						addStraight(i, j, k ,l);
					}
					else{
						addStraight(i, j, k);
					}
				}
			}
		}
	}
	
	private int checkForNext(int position, Suit s, Rank r){
		int furthest = position + 4;
		for(; (position < furthest) && (position < this.cardCount); position++){
			if(this.myHand[position].getSuit() == s){
				if(this.myHand[position].getRank().ordinal() == (r.ordinal() + 1)){
					return position;
				}				
			}
		}
		return 0;
	}
	
	private void addStraight(int i, int j, int k){
		this.straights[this.straightCount][0] = this.myHand[i];
		this.myHand[i].setInStraight(true);
		this.straights[this.straightCount][1] = this.myHand[j];
		this.myHand[j].setInStraight(true);
		this.straights[this.straightCount][2] = this.myHand[k];
		this.myHand[k].setInStraight(true);
		this.straightCount++;
	}
	
	private void addStraight(int i, int j, int k, int l){
		this.straights[this.straightCount][0] = this.myHand[i];
		this.myHand[i].setInStraight(true);
		this.straights[this.straightCount][1] = this.myHand[j];
		this.myHand[j].setInStraight(true);
		this.straights[this.straightCount][2] = this.myHand[k];
		this.myHand[k].setInStraight(true);
		this.straights[this.straightCount][3] = this.myHand[l];
		this.myHand[l].setInStraight(true);
		this.straightCount++;
	}
	
	public void clearStraights(){
		for(int i=0; i < this.cardCount; i++){
			this.myHand[i].setInStraight(false);
		}
		for(int j=0; j < 3; j++){
			for(int k=0; k < 4; k++){
				this.straights[j][k] = null;
			}
		}
		this.straightCount = 0;
	}
	
	private void addThreeOfAKind(int i, int j, int k){
		this.ofAKinds[this.ofAKindCount][0] = this.myHand[i];
		this.myHand[i].setInOfAKind(true);
		this.ofAKinds[this.ofAKindCount][1] = this.myHand[j];
		this.myHand[j].setInOfAKind(true);
		this.ofAKinds[this.ofAKindCount][2] = this.myHand[k];
		this.myHand[k].setInOfAKind(true);
		this.ofAKindCount++;
	}
	
	private void addFourOfAKind(int i, int j, int k, int l){
		this.ofAKinds[this.ofAKindCount][0] = this.myHand[i];
		this.myHand[i].setInOfAKind(true);
		this.ofAKinds[this.ofAKindCount][1] = this.myHand[j];
		this.myHand[j].setInOfAKind(true);
		this.ofAKinds[this.ofAKindCount][2] = this.myHand[k];
		this.myHand[k].setInOfAKind(true);
		this.ofAKinds[this.ofAKindCount][3] = this.myHand[l];
		this.myHand[l].setInOfAKind(true);
		this.ofAKindCount++;
	}
	
	/*public int countPoints(){
		
	}*/
	
	public String deckOrDiscard(){
		System.out.println("Please enter 1 to pick up from discard \n" + 
				"2 to pick up from deck");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int answer = Integer.parseInt(br.readLine());
			if(answer==1){return "Discard";} else{return "Deck";}
		}
		catch (IOException ioe) {
			return("IO error trying to read your choice!");
		}
	}
}
