package Cake_Ordering_Syetem;

import java.util.Date;

public class Order {
    private int orderId;
    private Date orderDate;
    private Cake cake;
    private Customer customer;

    
    public Order( int orderId, Customer customer, Cake cake,Date orderDate) 
    {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.cake = cake;
        this.customer = customer;
    }

   
    
   
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

   
    public void display() {
        
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Cake Details:");
        if (cake != null) {
            cake.display(); 
            
        }
        System.out.println("Customer Details:");
        if (customer != null) {
            customer.display(); 
        } else {
            System.out.println("No Customer Information");
        }
    }
}