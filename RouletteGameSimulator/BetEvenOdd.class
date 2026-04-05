
public class BetDozen extends Bet {
	int dozen;
	
	public BetDozen(int wagerAmount, int dozen) {
		super (wagerAmount);
		if (dozen != 1 && dozen != 2 && dozen != 3) {
			throw new IllegalArgumentException("Please enter a valid dozen (1, 2, or 3).");
		}
		this.dozen = dozen;
	}
	
	@Override
	public boolean isWinner(WheelResult result) {
		if(result.isGreen()) {
			return false;
		}
		if(dozen == 1) {
			return (result.number >= 1 && result.number <= 12);
		}
		if(dozen == 2) {
			return (result.number >= 13 && result.number <= 24);
		}
		if(dozen == 3) {
			return (result.number >= 25 && result.number <= 36);
		}
		return false;
	}
	
	@Override
	public int getPayoutMultiplier() {
		return  2;
	}
	
	@Override
	public String toString() {
		String range = (dozen == 1) ? "1-12" : (dozen == 2) ? "13-24" : "25-36";
		return "Dozen Bet: $" + wagerAmount + " on dozen " + dozen + " (" + range + ")";
	}
}
