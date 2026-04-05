
public class BetColumn extends Bet {
	int column;
	static int [][] columns = {
					{1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34},
					{2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35},
      				{3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36},
      				};

	
	public BetColumn(int wagerAmount, int column) {
		super (wagerAmount);
		if (column != 1 && column != 2 && column != 3) {
			throw new IllegalArgumentException("Please enter a valid column (1, 2, or 3).");
		}
		this.column = column;
	}
	
	@Override
	public boolean isWinner(WheelResult result) {
		if(result.isGreen()) {
			return false;
		} 
        for (int i = 0; i < columns[column - 1].length; i++) {
            if (result.number == columns[column - 1][i]) {
                return true;
            }
        }
        return false;
    }
	
	@Override
	public int getPayoutMultiplier() {
		return  2;
	}
	
	@Override
	public String toString() {
		return "Column Bet: $" + wagerAmount + " on column " + column;
	}
}
