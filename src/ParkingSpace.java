
public class ParkingSpace {
    private int spaceNumber; // unique identifier
    private boolean isOccupied;

    public ParkingSpace(int spaceNumber) {//constructor that initializes the space
        this.spaceNumber = spaceNumber;
        this.isOccupied = false;
    }

    //Getters and setters

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        isOccupied = true;
    }

    public void release() {
        isOccupied = false;
    }
}
