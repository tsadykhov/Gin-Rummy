package ginRummy;

public class Discard {

	private Card topOfDiscard;
	
	public Card getTop(){
		return this.topOfDiscard;
	}
	
	public void setTop(Card card){
		this.topOfDiscard = card;
	}
	
	public Card takeTop(){
		Card temp = topOfDiscard;
		topOfDiscard = null;
		return(temp);
	}
	
}
