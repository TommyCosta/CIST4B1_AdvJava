
public class PayoutQueue {
	public NodeBet head;
	public NodeBet tail;
	public int size;
	
	public PayoutQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void enqueue(Bet bet) {
		NodeBet newNode = new NodeBet(bet);
		
		// queue is empty
		if (this.head == null) {
			head = newNode;
			tail = newNode;
		}				
		// adding highest priority payout
		else if (newNode.bet.getPayoutMultiplier() <= this.head.bet.getPayoutMultiplier()) {
			newNode.right = head;   
			head.left = newNode; 
			head = newNode;  
		}
		// adding any other priority payout (find insertion point)
		else{    //  starting at the head, walk through queue nodes until end of queue or higher priority position is found
			NodeBet temp = head;
			while (temp.right != null && temp.right.bet.getPayoutMultiplier() <= newNode.bet.getPayoutMultiplier()) {
				temp = temp.right;
			}
			newNode.right = temp.right;
			newNode.left = temp;
			if (temp.right != null) {  // add at insertion point
				temp.right.left = newNode;
			} else {
				tail = newNode;  // add at end of queue
				}
			temp.right = newNode;
		}
		size++;
	}
	
	public NodeBet dequeue() {
		if (head == null) {  // empty queue
			return null;
		}
		NodeBet removed = head;  // copy head
		head = head.right;   //  make next node new head
		if (head != null) {   //  remove left connection from new head
			head.left = null;
		} else { // or list is now empty
			tail = null;
		}
		size--;
		return removed;
	}
	
	public void listBets() {
		if (size == 0) {
			System.out.println("There are currently no active bets.");
			return;
		}
		NodeBet temp = head;
		while (temp != null) {
			System.out.println(temp.bet.toString() + ".");
			temp = temp.right;
		}
	}
	
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
}
