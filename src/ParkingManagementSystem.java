public class ParkingManagementSystem {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(10); // create an instance of ParkingLot with 10 spaces

        parkingLot.printAvailableSpaces();  // Print available spaces
        parkingLot.parkCar();  // Park a car
        parkingLot.parkCar();  // Park a car
        parkingLot.parkCar();  // Park a car
        parkingLot.parkCar();  // Park a car
        parkingLot.parkCar();  // Park a car
        parkingLot.parkCar();  // Park a car
        parkingLot.parkCar();  // Park a car
        parkingLot.printAvailableSpaces();  // Print available spaces
        parkingLot.releaseCar(2);  // Release a car
        parkingLot.printAvailableSpaces();  // Print available spaces
        parkingLot.parkCar();  // Park a car
        parkingLot.parkCar();  // Park a car
        parkingLot.parkCar();  // Park a car
        parkingLot.parkCar();  // Park a car
        parkingLot.parkCar();  // Park a car
        parkingLot.printRevenueReport();  // Print revenue report
        parkingLot.releaseCar(6);
        parkingLot.releaseCar(8);
        parkingLot.releaseCar(1);
        parkingLot.printAvailableSpaces();
        parkingLot.printRevenueReport();  // Print revenue report

    }
}
