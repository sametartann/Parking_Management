# Parking Management System

This repository contains a Java implementation of a simple parking management system. The system utilizes linked lists and binary trees to manage parking spaces within a parking lot.

## Table of Contents
- [Overview](#overview)
- [Classes](#classes)
- [Usage](#usage)

## Overview

The project consists of the following classes:

- `LinkedList<T>`: A generic class representing a linked list implementation.
- `LinkedListNode<T>`: Node class for the linked list.
- `ParkingLot`: Manages the parking lot, handling parking and releasing cars.
- `ParkingSpace`: Represents an individual parking space.
- `Tree`: Binary search tree implementation.
- `TreeNode`: Node class for the binary tree.
- `ParkingManagementSystem`: Main class demonstrating the parking system's functionality.

## Classes

### `LinkedList<T>`
- Represents a generic linked list that can work with any type of data.
- Provides functionalities such as adding, removing, retrieving data, and displaying the list.

### `ParkingLot`
- Manages the parking lot by handling available and occupied parking spaces.
- Implements methods for parking cars, releasing cars, printing available spaces, and generating revenue reports.

### `ParkingSpace`
- Represents an individual parking space.
- Contains information about the space number and its occupancy status.

### `Tree` & `TreeNode`
- Implements a binary search tree for sorting parking spaces.
- Provides methods for insertion, deletion, and traversal.

### `ParkingManagementSystem`
- Contains the main method that demonstrates the functionalities of the parking system.
- Creates a parking lot with a specified number of spaces, parks and releases cars, and prints reports.

## Usage

To use the parking management system, you can create an instance of the `ParkingLot` class, specify the total number of parking spaces, and utilize the provided methods to park, release cars, and generate reports.

Example usage:

```java
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
```

Feel free to explore and extend the functionality of the parking management system as needed!

#### Samet ARTAN
