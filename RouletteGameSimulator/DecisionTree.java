import java.util.Scanner;

public class DecisionTree {
	NodeTree root;
    Scanner scanner;

    // Accept scanner from RouletteGame so the whole program shares one instance
    public DecisionTree(Scanner scanner) {
        this.scanner = scanner;
        buildTree();
    }

    private void buildTree() {

        // level 2 leaves, Low Risk (1:1)
    	NodeTree colorLeaf   = new NodeTree("COLOR");
    	NodeTree evenOddLeaf = new NodeTree("EVENODD");
    	NodeTree highLowLeaf = new NodeTree("HIGHLOW");

        // level 2 leaves, Medium Risk (2:1 to 8:1)
    	NodeTree dozenLeaf   = new NodeTree("DOZEN");
    	NodeTree columnLeaf  = new NodeTree("COLUMN");
    	NodeTree lineLeaf    = new NodeTree("LINE");
    	NodeTree basketLeaf  = new NodeTree("BASKET");
    	NodeTree cornerLeaf  = new NodeTree("CORNER");

        // level 2 leaves, High Risk (11:1 to 35:1)
    	NodeTree streetLeaf   = new NodeTree("STREET");
    	NodeTree splitLeaf    = new NodeTree("SPLIT");
    	NodeTree straightLeaf = new NodeTree("STRAIGHT");

        //  level 1 nodes, one per risk category
    	NodeTree lowRisk = new NodeTree(
            "Low risk bets pay 1:1. Which type?",
            new String[]{
                "1. Color Bet      (Red or Black)",
                "2. Even/Odd Bet   (Even or Odd)",
                "3. High/Low Bet   (1-18 or 19-36)"
            },
            new NodeTree[]{colorLeaf, evenOddLeaf, highLowLeaf}
        );

    	NodeTree mediumRisk = new NodeTree(
            "Medium risk bets pay 2:1 to 8:1. Which type?",
            new String[]{
                "1. Dozen Bet      (1-12, 13-24, or 25-36)   2:1",
                "2. Column Bet     (one of three columns)     2:1",
                "3. Line Bet       (6 numbers, two rows)      5:1",
                "4. Basket Bet     (0, 00, 1, 2, 3)           6:1",
                "5. Corner Bet     (4 numbers in a square)    8:1"
            },
            new NodeTree[]{dozenLeaf, columnLeaf, lineLeaf, basketLeaf, cornerLeaf}
        );

    	NodeTree highRisk = new NodeTree(
            "High risk bets pay 11:1 to 35:1. Which type?",
            new String[]{
                "1. Street Bet     (3 numbers in a row)       11:1",
                "2. Split Bet      (2 adjacent numbers)       17:1",
                "3. Straight Bet   (single number)            35:1"
            },
            new NodeTree[]{streetLeaf, splitLeaf, straightLeaf}
        );

        //  ROOT 
        root = new NodeTree(
            "How risky do you want your bet to be?",
            new String[]{
                "1. Low Risk    (1:1  payout) — Color, Even/Odd, High/Low",
                "2. Medium Risk (2:1 - 8:1)  — Dozen, Column, Line, Basket, Corner",
                "3. High Risk   (11:1 - 35:1) — Street, Split, Straight"
            },
            new NodeTree[]{lowRisk, mediumRisk, highRisk}
        );
    }

    
    // start recursive traversal from root
    public String traverse() {
        return traverseNode(root);
    }

    // Recursive traversal
    // Recursive case: display prompt and options, get input, recurse on chosen child
    private String traverseNode(NodeTree node) {

        // Base case: leaf node reached, return the bet type
        if (node.isLeaf()) {
            return node.betType;
        }
        
        System.out.println("\n" + node.prompt);
        System.out.println("-----------------------------");
        for (int i = 0; i < node.options.length; i++) {
            System.out.println(node.options[i]);
        }

        int choice = 0;
        while (choice < 1 || choice > node.children.length) {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine().strip());
                if (choice < 1 || choice > node.children.length) {
                    System.out.println("Invalid choice. Please enter a number between 1 and "
                                       + node.children.length + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // Recurse on the chosen child 
        return traverseNode(node.children[choice - 1]);
    }
}