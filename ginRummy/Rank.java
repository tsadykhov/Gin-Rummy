package ginRummy;

//enum of possible card Ranks
public enum Rank {

	ACE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(10),
	QUEEN(10),
	KING(10);
	
	//points determines amount of points each card is worth in Gin Rummy
	public final int points;
	
	//standard Rank constructor
	Rank(int points){
		this.points = points;
	}
}

