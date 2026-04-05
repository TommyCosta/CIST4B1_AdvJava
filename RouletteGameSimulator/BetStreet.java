
public class BetStreet extends Bet {
    int[] numbers;

    // Valid streets — each row is one legal set of 3 consecutive numbers
    private static int[][] VALID_STREETS = {
        {1,2,3},{4,5,6},{7,8,9},{10,11,12},
        {13,14,15},{16,17,18},{19,20,21},{22,23,24},
        {25,26,27},{28,29,30},{31,32,33},{34,35,36}
    };

    // Sorts a small int array using insertion sort
    private int[] sortArray(int[] nums) {
        int[] sorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i];
        }
        for (int i = 1; i < sorted.length; i++) {
            int key = sorted[i];
            int j   = i - 1;
            while (j >= 0 && sorted[j] > key) {
                sorted[j + 1] = sorted[j];
                j--;
            }
            sorted[j + 1] = key;
        }
        return sorted;
    }

    // Checks if two int arrays are equal element by element
    private boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public BetStreet(int wagerAmount, int[] numbers) {
        super(wagerAmount);
        if (numbers.length != 3) {
            throw new IllegalArgumentException("Street bet requires exactly 3 numbers.");
        }
        // Validate range
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 1 || numbers[i] > 36) {
                throw new IllegalArgumentException("Street numbers must be between 1 and 36.");
            }
        }
        // Sort and check against valid streets
        int[] sorted = sortArray(numbers);
        boolean valid = false;
        for (int i = 0; i < VALID_STREETS.length; i++) {
            if (arraysEqual(sorted, VALID_STREETS[i])) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new IllegalArgumentException("Those three numbers do not form "
                + "a valid street on the board.");
        }
        this.numbers = numbers;
    }

    @Override
    public boolean isWinner(WheelResult result) {
        for (int i = 0; i < numbers.length; i++) {
            if (result.number == numbers[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getPayoutMultiplier() {
        return 11;
    }

    @Override
    public String toString() {
        return "Street Bet: $" + wagerAmount + " on "
            + numbers[0] + ", " + numbers[1] + ", " + numbers[2];
    }
}
