
public class NodeTree {
    String prompt;      // question shown to user at this node
    String betType;     // non-null only at leaf nodes
    NodeTree[] children; // array of children, size varies per node
    String[] options;   // labels for each child option shown to user

    // Internal node. has a prompt, options, and children
    public NodeTree(String prompt, String[] options, NodeTree[] children) {
        this.prompt   = prompt;
        this.options  = options;
        this.children = children;
        this.betType  = null;
    }

    // Leaf node. just a bet type, no children
    public NodeTree(String betType) {
        this.betType  = betType;
        this.prompt   = null;
        this.options  = null;
        this.children = null;
    }

    public boolean isLeaf() {
        return children == null;
    }
}
