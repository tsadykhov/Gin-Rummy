package ginRummy;

//enum of possible card Suits
public enum Suit {
	
	CLUBS(1),
	DIAMONDS(2),
	HEARTS(3),
	SPADES(4);
	
	//order ranks the suits from lowest to highest
	public final int order;
	
	//standard Suit constructor
	Suit(int order){
		this.order = order;
	}
}
