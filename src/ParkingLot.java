public class ParkingLot { // represents a parking lot
    // store the available and occupied parking spaces in LinkedList
    private LinkedList<ParkingSpace> availableSpaces;
    private LinkedList<ParkingSpace> occupiedSpaces;
    private Tree entranceTree; //Tree
    private int totalSpace;

    public ParkingLot(int totalSpaces) { //initializes the parking lot
        availableSpaces = new LinkedList<>();
        occupiedSpaces = new LinkedList<>();
        entranceTree = new Tree();
        this.totalSpace= totalSpaces;

        // initialize parking spaces
        for (int i = 1; i <= totalSpace; i++) {
            ParkingSpace space = new ParkingSpace(i);
            availableSpaces.add(space);
            entranceTree.insert(space);
        }
    }

    public void parkCar() { // park a car in the parking lot
        if (availableSpaces.isEmpty()) {
            System.out.println("Parking lot is full. No available spaces.");
        } else {
            // remove the first parking space from the availableSpaces list, marks it as occupied
            ParkingSpace space = availableSpaces.removeFirst();
            space.occupy();
            occupiedSpaces.add(space);
            sortOccupiedSpaces();
            System.out.println("Car parked in space " + space.getSpaceNumber());
        }
    }

    public void releaseCar(int spaceNumber) {
        ParkingSpace releasedSpace = null; // to store the released parking space
        for (int i = 0; i < occupiedSpaces.getSize(); i++) {
            ParkingSpace space = occupiedSpaces.get(i);
            if (space.getSpaceNumber() == spaceNumber) {
                space.release();
                releasedSpace = space;
                break;
            }
        }

        if (releasedSpace != null) { //  if a parking space was successfully released
            occupiedSpaces.remove(releasedSpace);
            availableSpaces.add(releasedSpace);
            entranceTree.insert(releasedSpace);

            // Sort the available spaces based on spaceNumber
            sortAvailableSpaces();
            System.out.println("Car released from space " + releasedSpace.getSpaceNumber());
        } else {
            System.out.println("Invalid space number. No car found.");
        }
    }

    private void sortAvailableSpaces() {
        TreeNode sortedRoot = null; // represent the root node of a binary search tree
        for (int i = 0; i < availableSpaces.getSize(); i++) {
            ParkingSpace space = availableSpaces.get(i);
            TreeNode newNode = new TreeNode(space);
            sortedRoot = insertIntoSortedTree(sortedRoot, newNode);
        }

        // Rebuild the availableSpaces list based on the sorted tree
        availableSpaces = new LinkedList<>(); // to hold the sorted parking spaces
        traverseSortedTree(sortedRoot, availableSpaces); // recursively traverses the sorted binary search tree and populates the availableSpaces list in the correct order
    }

    private void sortOccupiedSpaces() {
        TreeNode sortedRoot = null; // represent the root node of a binary search tree
        for (int i = 0; i < occupiedSpaces.getSize(); i++) {
            ParkingSpace space = occupiedSpaces.get(i);
            TreeNode newNode = new TreeNode(space);
            sortedRoot = insertIntoSortedTree(sortedRoot, newNode);
        }

        // Rebuild the availableSpaces list based on the sorted tree
        occupiedSpaces = new LinkedList<>(); // to hold the sorted occupied spaces
        traverseSortedTree(sortedRoot, occupiedSpaces);
    }

    private TreeNode insertIntoSortedTree(TreeNode root, TreeNode newNode) {
        // inserting a new TreeNode into the binary search tree while maintaining the sort order
        if (root == null) {
            return newNode;
        }

        // compare the space numbers of the new node and the current root node to determine the appropriate placement in the tree
        if (newNode.getSpace().getSpaceNumber() < root.getSpace().getSpaceNumber()) {
	        	/* If the space number of the new node is less than the root's space number, the method recursively calls
	        	itself to insert the new node into the left subtree of the current root.*/

            root.setLeft(insertIntoSortedTree(root.getLeft(), newNode));
        } else {
	        	/*If the space number of the new node is greater than or equal to the root's space number, the method
	        	 recursively calls itself to insert the new node into the right subtree of the current root */

            root.setRight(insertIntoSortedTree(root.getRight(), newNode));
        }

        return root;
    }

    private void traverseSortedTree(TreeNode root, LinkedList<ParkingSpace> sortedList) { // traversing the sorted binary search tree in an in-order manner
        if (root == null) {
            return;
        }

        traverseSortedTree(root.getLeft(), sortedList); // call the method on the left subtree of the current root node
        sortedList.add(root.getSpace()); // add the parking space stored in the current root node to the sortedList
        traverseSortedTree(root.getRight(), sortedList); // call the method on the right subtree of the current root node
    }

    public void printAvailableSpaces() { // print the available spaces in the parking lot
        System.out.print("Available Spaces:{");
        for (int i = 0; i < availableSpaces.getSize(); i++) {
            ParkingSpace space = availableSpaces.get(i);
            System.out.print("Space " + space.getSpaceNumber()+',');
        }
        System.out.println("}");
	        /*
	        for (ParkingSpace space : availableSpaces) {
	            System.out.println("Space " + space.getSpaceNumber());
	        }*/
    }

    public void printRevenueReport() {	// print a revenue report for the occupied spaces in the parking lot.
        double revenue = 5.00;
        System.out.println("Revenue Report:");
        for (int i = 0; i < occupiedSpaces.getSize(); i++) {
            ParkingSpace space = occupiedSpaces.get(i);
            System.out.println("Space " + space.getSpaceNumber() + " - Revenue: $" + revenue);
        }
	        /*
	        for (ParkingSpace space : occupiedSpaces) {
	            System.out.println("Space " + space.getSpaceNumber() + " - Revenue: $" + revenue);
	        }*/
    }
}
