package ginRummy;

public enum Colors {
	BLUE(1),
	YELLOW(2),
	GREEN(3);
	
	private final int value;
	
	Colors(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
