
public class SpinStack {
    private int maxSize;
    private int currentSize;
    private WheelResult[] data;

    // fixed at 10
    public SpinStack() {
        this.maxSize     = 10;
        this.currentSize = 0;
        this.data        = new WheelResult[maxSize];
    }

    // add a new spin result onto the stack
    public void push(WheelResult result) {
        if (currentSize < maxSize) {
            data[currentSize] = result;
            currentSize++;
        } else {   			 // if stack is full, drop the oldest entry to make room
            for (int i = 0; i < maxSize - 1; i++) {
                data[i] = data[i + 1];
            }
            data[maxSize - 1] = result;
        }
    }

    public WheelResult pop() {
        if (currentSize > 0) {
            currentSize--;
            WheelResult returnValue = data[currentSize];
            data[currentSize] = null;
            return returnValue;
        } else {
            System.err.println("Error: Attempting to pop from empty stack.");
            return null;
        }
    }

    public WheelResult peek() {
        if (currentSize > 0) {
            return data[currentSize - 1];
        } else {
            System.err.println("Error: Attempting to peek at empty stack.");
            return null;
        }
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Display last 10 spins from most recent to oldest
    public void displayHistory() {
        if (isEmpty()) {
            System.out.println("No spins yet.");
            return;
        }
        System.out.println("=================================");
        System.out.println("        LAST " + currentSize + " SPINS           ");
        System.out.println("=================================");
        for (int i = currentSize - 1; i >= 0; i--) {
            String display = (data[i].number == 37) ? "00" : String.valueOf(data[i].number);
            System.out.println(display + "   (" + data[i].color + ")");
        }
        System.out.println("=================================");
    }
}