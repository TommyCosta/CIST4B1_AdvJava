
public class BetCorner extends Bet {
    int[] numbers;

    // Valid corner quads (4 numbers forming a square on the board)
    private static int[][] VALID_CORNERS = {
        {1,2,4,5},{2,3,5,6},{4,5,7,8},{5,6,8,9},
        {7,8,10,11},{8,9,11,12},{10,11,13,14},{11,12,14,15},
        {13,14,16,17},{14,15,17,18},{16,17,19,20},{17,18,20,21},
        {19,20,22,23},{20,21,23,24},{22,23,25,26},{23,24,26,27},
        {25,26,28,29},{26,27,29,30},{28,29,31,32},{29,30,32,33},
        {31,32,34,35},{32,33,35,36}
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

    // Check if two int arrays are equal element by element
    private boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public BetCorner(int wagerAmount, int[] numbers) {
        super(wagerAmount);
        if (numbers.length != 4) {
            throw new IllegalArgumentException("Corner bet requires exactly 4 numbers.");
        }
        // Validate range
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > 36) {
                throw new IllegalArgumentException("Numbers must be between 0 and 36.");
            }
        }
        // Sort and check against valid corners
        int[] sorted = sortArray(numbers);
        boolean valid = false;
        for (int i = 0; i < VALID_CORNERS.length; i++) {
            if (arraysEqual(sorted, VALID_CORNERS[i])) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new IllegalArgumentException("Those four numbers do not form "
                + "a valid corner on the board.");
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
        return 8;
    }

    @Override
    public String toString() {
        return "Corner Bet: $" + wagerAmount + " on "
            + numbers[0] + ", " + numbers[1] + ", "
            + numbers[2] + ", " + numbers[3];
    }
}
