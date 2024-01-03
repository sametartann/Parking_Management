public class Tree {
    private TreeNode root;

    public Tree() { // constructor
        root = null;
    }

    public void insert(ParkingSpace space) {
        TreeNode newNode = new TreeNode(space); // create a new TreeNode object with the provided space

        if (root == null) {
            root = newNode;
        } else {
            insertNode(root, newNode);
        }
    }

    private void insertNode(TreeNode currentNode, TreeNode newNode) { // recursive method for inserting a node into the tree
        if (newNode.getSpace().getSpaceNumber() < currentNode.getSpace().getSpaceNumber()) {
            if (currentNode.getLeft() == null) { // check if the left child of the currentNode is null
                currentNode.setLeft(newNode); // newNode is now left child
            } else {
                insertNode(currentNode.getLeft(), newNode); // method is called recursively with the left child as the new currentNode
            }
        }
        /* if the spaceNumber of the newNode is greater than or equal to the spaceNumber of the currentNode,
           it follows a similar process for the right child of the currentNode*/
        else {
            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
            } else {
                insertNode(currentNode.getRight(), newNode);
            }
        }
    }

    public void delete(ParkingSpace space) {
        root = deleteNode(root, space); // delete the node containing that space from the tree
    }

    private TreeNode deleteNode(TreeNode currentNode, ParkingSpace space) { // recursive method for deleting a node from the tree
        if (currentNode == null) {
            return null;
        }

        if (space.getSpaceNumber() < currentNode.getSpace().getSpaceNumber()) {
            currentNode.setLeft(deleteNode(currentNode.getLeft(), space)); // recursively call deleteNode with the left child of the currentNode
        } else if (space.getSpaceNumber() > currentNode.getSpace().getSpaceNumber()) {
            currentNode.setRight(deleteNode(currentNode.getRight(), space)); // recursively call deleteNode with the right child of the currentNode.
        } else { // if the spaceNumber of the space to be deleted is equal to the spaceNumber of the currentNode
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                return null;
                /* if the currentNode has no left child and no right child, it simply returns null to remove the node*/
            }
            else if (currentNode.getLeft() == null) {
                return currentNode.getRight();
                /* if the currentNode has no left child but has a right child, it returns the right child to replace the currentNode*/
            }
            else if (currentNode.getRight() == null) {
                return currentNode.getLeft();
                /* if the currentNode has no right child but has a left child, it returns the left child to replace the currentNode.*/
            } else {
                TreeNode successor = findMinNode(currentNode.getRight());
                currentNode.setSpace(successor.getSpace());
                currentNode.setRight(deleteNode(currentNode.getRight(), successor.getSpace()));
                /*if the currentNode has both left and right children, it finds the minimum node in the right subtree (which is the
                 successor of the currentNode), assigns its space to the currentNode, and recursively deletes the successor node
                 from the right subtree.*/
            }
        }

        return currentNode;
    }

    private TreeNode findMinNode(TreeNode node) { //find the minimum node in the subtree rooted at that node
        while (node.getLeft() != null) {
            node = node.getLeft(); // iteratively traverses to the left child until the left child becomes null, indicating  minimum node found.
        }
        return node;
    }

    // Getters and Setters.

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
