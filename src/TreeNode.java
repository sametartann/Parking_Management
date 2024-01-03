
public class TreeNode { // representing a node in a binary tree
    // Each node contains a reference to a ParkingSpace object, as well as references to its left and right child nodes.
    private ParkingSpace space;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(ParkingSpace space) { // constructor
        this.space = space;
        left = null;
        right = null;
    }

    // Getters and Setters.

    public ParkingSpace getSpace() {
        return space;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setSpace(ParkingSpace space) {
        this.space = space;
    }

}
