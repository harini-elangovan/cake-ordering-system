package Cake_Ordering_Syetem;

public class Customer {
    private int customerId;
    private String fullName;
    private int contactNumber;
    private String deliveryAddress;

    public Customer(int customerId, String fullName, String deliveryAddress, int contactNumber) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.deliveryAddress = deliveryAddress;
    }

    
    


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setFullName(String customerName) {
        this.fullName = customerName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    
    public void display() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + fullName);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Delivery Address: " + deliveryAddress);
    }
}