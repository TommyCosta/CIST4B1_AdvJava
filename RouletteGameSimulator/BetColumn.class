
public class BetColor extends Bet {
	String chosenColor;
			
	public BetColor(int wagerAmount, String chosenColor) {
		super (wagerAmount);
		if (chosenColor.strip().toLowerCase() != "red" && chosenColor.strip().toLowerCase() != "black") {
			throw new IllegalArgumentException("Please enter a valid color (red or black).");
		}
		this.chosenColor = chosenColor;
	}
	
	@Override
	public boolean isWinner(WheelResult result) {
		if(result.isGreen()) {
			return false;
		}
		if (result.color.equals(this.chosenColor)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int getPayoutMultiplier() {
		return  1;
	}
	
	@Override
	public String toString() {
		return "Color Bet: $" + wagerAmount + " on " + chosenColor;
	}
}
