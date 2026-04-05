
public abstract class Bet {
	int wagerAmount;
	
	public Bet(int wagerAmount) {
		if (wagerAmount <= 0 ) {
			throw new IllegalArgumentException("Please enter a valid wager amount (greater than 0).");
		}
		this.wagerAmount = wagerAmount;
	}
	
	// overridden by subclasses
	public abstract boolean isWinner(WheelResult result);
	
	// overridden by subclasses
	public abstract int getPayoutMultiplier();
	
	// inherited by subclasses
	public int calculatePayout() {
		return wagerAmount * getPayoutMultiplier() + wagerAmount;
	}
	
	public String toString() {
		return "Bet: $" + wagerAmount;
	}
	
}
