
public class BetEvenOdd extends Bet {
	String chosenParity;
	
	public BetEvenOdd(int wagerAmount, String chosenParity) {
		super (wagerAmount);
		if (chosenParity.strip().toLowerCase() != "even" && chosenParity.strip().toLowerCase() != "odd") {
			throw new IllegalArgumentException("Please enter a valid parity (even or odd).");
		}
		this.chosenParity = chosenParity;
	}
	
	@Override
	public boolean isWinner(WheelResult result) {
		if(result.isGreen()) {
			return false;
		}
		if (chosenParity.equals("odd")) {
			return result.isOdd;
		} else {
			return !result.isOdd;
		}
	}
	
	@Override
	public int getPayoutMultiplier() {
		return  1;
	}
	
	@Override
	public String toString() {
		return "Even/Odd Bet: $" + wagerAmount + " on " + chosenParity;
	}
}
