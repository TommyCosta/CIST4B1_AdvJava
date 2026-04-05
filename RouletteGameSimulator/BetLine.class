
public class BetHighLow extends Bet {
	String chosenHiLo;
	
	public BetHighLow(int wagerAmount, String chosenHiLo) {
		super (wagerAmount);
		if (chosenHiLo.strip().toLowerCase() != "high" && chosenHiLo.strip().toLowerCase() != "low") {
			throw new IllegalArgumentException("Please enter a valid parity (even or odd).");
		}
		this.chosenHiLo = chosenHiLo;
	}
	
	@Override
	public boolean isWinner(WheelResult result) {
		if(result.isGreen()) {
			return false;
		}
		if(chosenHiLo.equals("low")) {
			return (result.number >= 1 && result.number <= 18);
		}
		else {
			return (result.number >= 19 && result.number <= 36);
		}
	}
	
	@Override
	public int getPayoutMultiplier() {
		return  1;
	}
	
	@Override
	public String toString() {
		return "High/Low Bet: $" + wagerAmount + " on " + chosenHiLo;
	}
}
