
public class TableBet {
	TableBetEntry[] entries;
	
	// construct array of objects (bet types)
	public TableBet() {
		entries = new TableBetEntry[11];
		
		entries[0] = new TableBetEntry("Color Bet", 1, 18.0/38.0, "Bet on red or black squares.");
		entries[1] = new TableBetEntry("Even/Odd Bet", 1, 18.0/38.0, "Bet on even or odd numbers.");
		entries[2] = new TableBetEntry("High/Low Bet", 1, 18.0/38.0, "Bet on low (1-18) or high (19-36) numbers.");
		entries[3] = new TableBetEntry("Dozen Bet", 2, 12.0/38.0, "Bet on 1st (1-12), 2nd (13-24), or 3rd (25-36) dozen.");
		entries[4] = new TableBetEntry("Column Bet", 2, 12.0/38.0, "Bet on one of three columns on the board.");
		entries[5] = new TableBetEntry("Straight Bet", 35, 1.0/38.0, "Bet on a single number (0-36 or 00).");
		entries[6] = new TableBetEntry("Split Bet", 17, 2.0/38.0, "Bet on two adjacent numbers on the board.");
		entries[7] = new TableBetEntry("Corner Bet", 8, 4.0/38.0, "Bet on four numbers forming a square on the board.");
		entries[8] = new TableBetEntry("Street Bet", 11, 3.0/38.0, "Bet on three consecutive numbers in one row.");
		entries[9] = new TableBetEntry("Line Bet", 5, 6.0/38.0, "Bet on 6 numbers across two adjacent rows.");
		entries[10] = new TableBetEntry("Basket Bet", 6, 5.0/38.0, "Bet on 0, 00, 1, 2, and 3.");
	}
	
    // Insertion sort - entries by payout ratio descending
	public void sortByPayout() {
	    for (int i = 1; i < entries.length; i++) {
	        TableBetEntry key = entries[i];
	        int j = i - 1;
	        // Shift entries right until we find the correct position for key
	        while (j >= 0 && entries[j].payoutRatio < key.payoutRatio) {
	            entries[j + 1] = entries[j];
	            j--;
	        }
	        entries[j + 1] = key;
	    }
	}

    // Insertion sort entries by win probability descending
    public void sortByOdds() {
        for (int i = 1; i < entries.length; i++) {
            TableBetEntry key = entries[i];
            int j = i - 1;
            // Shift entries right until find the correct position for key
            while (j >= 0 && entries[j].winProbability < key.winProbability) {
                entries[j + 1] = entries[j];
                j--;
            }
            entries[j + 1] = key;
        }
    }
    
    public void display() {
        System.out.println("             BET REFERENCE TABLE         ");
        System.out.println("===========================================");
        for (int i = 0; i < entries.length; i++) {
            System.out.println(entries[i].toString());
            System.out.println("-------------------------------------------");
        }
    }
}
