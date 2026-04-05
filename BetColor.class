
public class BetBasket extends Bet {
	public BetBasket(int wagerAmount) {
		super (wagerAmount);
	}
	
	@Override
	public boolean isWinner(WheelResult result) {
		if(result.number == 0 || result.number == 37 || result.number == 1 || result.number == 2 || result.number == 3) {
			return true;
		}
		return false;
	}
	
	@Override
	public int getPayoutMultiplier() {
		return  6;
	}
	
	@Override
	public String toString() {
		return "Basket Bet: $" + wagerAmount + " on [0, 00, 1, 2, 3]";
	}
}
