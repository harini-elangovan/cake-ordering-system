
package Cake_Ordering_Syetem;

public class Cake {
    private String cakeCode;
    private String cakeName;
    private double cakePrice;

    // Constructor
    public Cake(String cakeCode, String cakeName, double cakePrice) {
        this.cakeCode = cakeCode;
        this.cakeName = cakeName;
        this.cakePrice = cakePrice;
    }

    
    public void setCakeCode(String cakeCode) {
        this.cakeCode = cakeCode;
    }

    public String getCakeCode() {
        return cakeCode;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakePrice(double cakePrice) {
        this.cakePrice = cakePrice;
    }

    public double getCakePrice() {
        return cakePrice;
    }

    
    public void display() {
        System.out.println("Cake Code: " + cakeCode);
        System.out.println("Cake Name: " + cakeName);
        System.out.println("Cake Price: $" + cakePrice);
    }
}