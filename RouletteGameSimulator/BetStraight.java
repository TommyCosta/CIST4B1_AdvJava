
public class BetStraight extends Bet {
	int chosenNumber;
	
	public BetStraight(int wagerAmount, int chosenNumber) {
		super (wagerAmount);
		if (chosenNumber < 0 || chosenNumber > 37) {
			throw new IllegalArgumentException("Please enter a valid number (0 - 37).");
		}
		this.chosenNumber = chosenNumber;
	}
	
	@Override
	public boolean isWinner(WheelResult result) {
		if(result.number == chosenNumber) {
			return true;
		}
		return false;
	}
	
	@Override
	public int getPayoutMultiplier() {
		return  35;
	}
	
	@Override
	public String toString() {
		String numberToString = (this.chosenNumber == 37) ? "00" : String.valueOf(chosenNumber); 
		return "Straight Bet: $" + wagerAmount + " on " + numberToString;
	}
}
