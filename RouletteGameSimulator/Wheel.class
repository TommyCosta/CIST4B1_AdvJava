
public class TableBetEntry {
	String name;
	String description;
	int payoutRatio;
	double winProbability;
	
	public TableBetEntry(String name, int payoutRatio, double winProbability, String description) {
		this.name = name;
		this.payoutRatio = payoutRatio;
		this.winProbability = winProbability;
		this.description = description;
	}
	
	public String toString() {
		return name + " | Payout : " + payoutRatio + " | Odds: " + String.format("%.2f%%", winProbability * 100) + "\n" + description;
	}
}
