# Cake Ordering System

A Java-based console application for managing cakes, customers, and cake orders.

## Features

- Add, update, delete, and view cakes
- Add, update, delete, and view customers
- Create and cancel cake orders
- View all orders
- Generate order reports by:
  - Date
  - Cake
  - Customer
- View the total number of orders
- Input validation and error handling

## Technologies

- Java
- ArrayList
- Java Date and Time API
- Object-Oriented Programming

## OOP Concepts Demonstrated

This project demonstrates several core Java and object-oriented programming concepts:

- Classes and objects
- Encapsulation
- Constructors
- Getters and setters
- Object relationships
- Collections using ArrayList
- Methods and control structures
- Exception handling
- Input validation

## Project Structure

```text
Cake_Ordering_Syetem
    Cake.java
    Customer.java
    Order.java
    CakeOrderingSystem.java
```

## Class Overview

### Cake.java

Stores cake information such as cake code, name, and price.

### Customer.java

Stores customer details including customer ID, name, contact number, and delivery address.

### Order.java

Represents an order and connects a customer with a cake and order date.

### CakeOrderingSystem.java

Contains the main application logic, menus, cake and customer management, order management, and reporting functions.

## How to Run

Compile the Java source files:

```bash
javac -d /tmp/cake-build *.java
```

## Run the application:

```
java -cp /tmp/cake-build Cake_Ordering_Syetem.CakeOrderingSystem
```

## Example Menu
```
*** Main Menu ***
1. Manage Cakes
2. Manage Customers
3. Manage Orders
4. Generate Reports
0. Exit
```
## Project Status

This project is a Java console application developed as part of my learning and practice in Java programming and object-oriented programming.
