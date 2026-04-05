import java.util.Random;

public class WheelResult {
	int number;
	String color;
	boolean isOdd;
	
	public WheelResult() {
		int [] blackNumbers = {2, 4, 6, 8, 10, 11, 13, 15, 17, 19, 20, 22, 24, 26, 29, 31, 33, 35};
	
		// randomly generate a number from 0-37 (37 represents 00)
		Random random = new Random();
		this.number = random.nextInt(38); //0-37
	
		// mark color as red or black depending on randomly generated number
		this.color = "red";
		for (int i = 0; i < blackNumbers.length; i++) {
		    if (this.number == blackNumbers[i]) {
		        this.color = "black";
		        break;
		    }
		}
		if (this.number == 0 || this.number == 37) {
		    this.color = "green";
		}
		
		// make isOdd boolean t/f depending on randomly generated number
		// NOTE: this.number == 0 or this.number == 37 will result in t/f, but 0 and 00 are neither odd nor even in roulette. this needs to be handled in Bet subclass
		this.isOdd = (this.number % 2 != 0);
	}
	
	// helper for subclasses handling 0 and 00
	public boolean isGreen() {
	    return this.number == 0 || this.number == 37;
	}
	
	public String toString() {
		String parity = (number == 0 || number == 37) ? "Neither" : (isOdd ? "Odd" : "Even");
		return "Number: " + number + " | Color: " + color + " | Parity: " + parity;
	}
}
