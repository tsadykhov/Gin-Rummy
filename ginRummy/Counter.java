package ginRummy;

public class Counter {
	Counter (){}
	
	private Card[][] straights = new Card[3][4];
	private Card[][] ofAKinds = new Card[3][4];
	private int straightCount = 0;
	private int ofAKindCount = 0;
	private int points = 0;
	
	public int getPoints(){
		
		return points;
	}
}
