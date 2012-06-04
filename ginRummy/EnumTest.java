package ginRummy;

public class EnumTest {

	Colors colors;
	
	public EnumTest(Colors colors){
		this.colors = colors;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*int i = 0;
		for(Rank r : Rank.values()){
			for(Suit s : Suit.values()){
				System.out.println(r.name() + " " + s.name());
				System.out.println(i++);
			}
		}*/
		
		Card aceOfSpades = new Card(0,3);
		Deck deck1 = new Deck();
		Card[] myDeck = (deck1).getDeck();
		
		for(int i=0; i < myDeck.length; i++){
			System.out.println("Card: " + myDeck[i].getRank()
					+ " of " + myDeck[i].getSuit());
		}
	}

}
