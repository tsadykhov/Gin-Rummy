package ginRummy;

public class Card {
	
	private Rank rank;
	private Suit suit;
	private boolean inPlay = false;
	private boolean inStraight = false;
	private boolean inOfAKind = false;
	private boolean inDiscard = false; //do I need this?
	
	Card(){}
	
	Card(Rank rank, Suit suit){
		//need to check that rank and suit given are valid
		this.rank = rank;
		this.suit = suit;
	}
	
	Card(int rankNum, int suitNum){
		//need to check that rankNum is between 0-12 & suitNum is between 0-3
		for (Rank r : Rank.values()){
			if(r.ordinal() == rankNum)
				this.rank = r;
		}
		for (Suit s : Suit.values()){
			if(s.ordinal() == suitNum)
				this.suit = s;
		}
	}

	public int getPoints(){
		return this.rank.points;
	}
	
	public int getOrder(){
		return this.suit.order;
	}
	
	public Rank getRank(){
		return this.rank;
	}
	
	public Suit getSuit(){
		return this.suit;
	}
	
	public boolean getInPlay(){
		return inPlay;
	}
	
	public void setInPlay(boolean inPlay){
		this.inPlay = inPlay;
	}
	
	public boolean getInStraight(){
		return this.inStraight;
	}
	
	public void setInStraight(boolean inStraight){
		this.inStraight = inStraight;
	}
	
	public boolean getInOfAKind(){
		return this.inOfAKind;
	}
	
	public void setInOfAKind(boolean inOfAKind){
		this.inOfAKind = inOfAKind;
	}
}

