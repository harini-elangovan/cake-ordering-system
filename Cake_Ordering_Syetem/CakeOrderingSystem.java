package Cake_Ordering_Syetem;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
public class CakeOrderingSystem {

    private ArrayList<Cake> cakes;
        private ArrayList<Customer> customers;
        private ArrayList<Order> orders;

        public CakeOrderingSystem() {
            cakes = new ArrayList<>();
            customers = new ArrayList<>();
            orders = new ArrayList<>();
        }

        public void addCake(Cake cake) {
            cakes.add(cake);
        }

        public void updateCake(String cakeCode, Cake updatedCake) {
            for (int i = 0; i < cakes.size(); i++) {
                if (cakes.get(i).getCakeCode().equals(cakeCode)) {
                    cakes.set(i, updatedCake);
                    return;
                }
            }
        }

        public void deleteCake(String cakeCode) {
            for (int i = 0; i < cakes.size(); i++) {
                if (cakes.get(i).getCakeCode().equals(cakeCode)) {
                    cakes.remove(i);
                    return;
                }
            }
        }

        
        public void viewCakes() {
            if (cakes.isEmpty()) {
                System.out.println("No cakes available.");
                return;
            }
            System.out.println("**** Cake List ****");
            for (int i = 0; i < cakes.size(); i++) {
                System.out.println("----------------------------------");
                cakes.get(i).display();
                System.out.println("----------------------------------");
            }
        }

        public void addCustomer(Customer customer) {
            customers.add(customer);
        }

        public void updateCustomer(int customerId, Customer updatedCustomer) {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getCustomerId() == customerId) {
                    customers.set(i, updatedCustomer);
                    return;
                }
            }
        }

        public void deleteCustomer(int customerId) {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getCustomerId() == customerId) {
                    customers.remove(i);
                    return;
                }
            }
        }
        

       
        public void viewCustomers() {
            if (customers.isEmpty()) {
                System.out.println("No customers available.");
                return;
            }
            System.out.println("**** Customer List ****");
            
            for (int i = 0; i < customers.size(); i++) {
                System.out.println("----------------------------------");
                customers.get(i).display();
                System.out.println("----------------------------------");
            }
        }

        public void makeOrder(Order order) {
            orders.add(order);
        }

        public void cancelOrder(int orderId) {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getOrderId() == orderId) {
                    orders.remove(i);
                    return;
                }
            }
        }

       

        public void viewOrders() {
            if (orders.isEmpty()) {
                System.out.println("No orders found.");
            } else {
                for (int i = 0; i < orders.size(); i++) {
                    System.out.println("----------------------------------");
                    orders.get(i).display();  
                    System.out.println("----------------------------------");
                }
            }
        }
        
        public void generateReportByDate(Date date) {
            boolean found = false;
            System.out.println("Orders for " + date + ":");
        
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getOrderDate().equals(date)) {
                    orders.get(i).display(); 
                    System.out.println("------------------------------");
                    found = true;
                }
            }
        
            if (!found) {
                System.out.println("No orders found for date: " + date);
            }
        }
        
        public void generateReportByCake(String cakeCode) {
            boolean found = false;
            System.out.println("Orders for Cake Code: " + cakeCode);
        
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getCake() != null && orders.get(i).getCake().getCakeCode().equals(cakeCode)) {
                    orders.get(i).display();
                   
                    System.out.println("------------------------------");
                    found = true;
                }
            }
        
            if (!found) {
                System.out.println("No orders found for Cake Code: " + cakeCode);
            }
        }
        
        public void generateReportByCustomer(int customerId) {
            boolean found = false;
            System.out.println("Orders for Customer ID: " + customerId);
        
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getCustomer() != null && orders.get(i).getCustomer().getCustomerId() == customerId) {
                    orders.get(i).display();
                    
                    System.out.println("------------------------------");
                    found = true;
                }
            }
        
            if (!found) {
                System.out.println("No orders found for Customer ID: " + customerId);
            }
        }
        
        public String generateTotalOrderReport() {
            System.out.println("Total number of orders: " + orders.size());
            return null;
        }
        

        public static void main(String[] args) {
            System.out.println("Cake Heaven Shop");
            CakeOrderingSystem system = new CakeOrderingSystem();
            Scanner scanner = new Scanner(System.in);

            Customer customer1 = new Customer(1001, "John Doe", "123 Street, NY", 987654321);
                Customer customer2 = new Customer(1002, "Jane Smith", "456 Avenue, CA", 123456789);
                system.addCustomer(customer1);
                system.addCustomer(customer2);
   
                Cake cake1 = new Cake("C001", "Vanilla Cake", 10.00);
                Cake cake2 = new Cake("C002", "Chocolate Cake", 15.00);
                system.addCake(cake1);
                system.addCake(cake2);

                Date date1 = Date.valueOf("2024-02-10");
                Date date2 = Date.valueOf("2024-02-15");
                Date date3 = Date.valueOf("2024-02-20"); 

            
               
                                                
                 
                Order order1 = new Order(5001, customer1, cake1, date1 );
                Order order2 = new Order(5002, customer2, cake2, date2 );
                Order order3 = new Order(5003, customer1, cake2, date3 );
                                                                        
                
                system.makeOrder(order1);
                system.makeOrder(order2);
                system.makeOrder(order3);



            int option = -1; 
        
            do {
                System.out.println("*** Main Menu ***");
                System.out.println("1. Manage Cakes");
                System.out.println("2. Manage Customers");
                System.out.println("3. Manage Orders");
                System.out.println("4. Generate Reports");
                System.out.println("0. Exit");
                System.out.print("Enter option: ");
                
                try {
                    option = scanner.nextInt();
                    scanner.nextLine(); 
        
                    switch (option) {
                        case 1:
                            manageCakesMenu(system, scanner);
                            break;
                        case 2:
                            manageCustomersMenu(system, scanner);
                            break;
                        case 3:
                            manageOrdersMenu(system, scanner);
                            break;
                        case 4:
                            generateReportsMenu(system, scanner);
                            break;
                        case 0:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Invalid input. Please enter a number between 0 and 4.");
                    scanner.nextLine(); 
                    option = -1; 
                }
            } while (option != 0);
        
            scanner.close();
        }
                                                                                                           
                                
                                        

                private static void manageCakesMenu(CakeOrderingSystem system, Scanner scanner) {
                int option;
                do {
                    System.out.println("** Cake Menu **");
                    System.out.println("1. Create Cake");
                    System.out.println("2. Update Cake");
                    System.out.println("3. Delete Cake");
                    System.out.println("4. View all Cakes");
                    System.out.println("5. Back to Main Menu");
                    System.out.print("Enter option: ");
                    
                    try {
                        option = scanner.nextInt();
                        scanner.nextLine(); 
            
                        switch (option) {
                            case 1:
                                createCake(system, scanner);
                                break;
                            case 2:
                                updateCake(system, scanner);
                                break;
                            case 3:
                                deleteCake(system, scanner);
                                break;
                            case 4:
                                system.viewCakes();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: Invalid input. Please enter a number.");
                        scanner.nextLine(); 
                        option = -1; 
                    }
                } while (option != 5);
            }
            
            private static void createCake(CakeOrderingSystem system, Scanner scanner) {
                try {
                    System.out.print("Enter Cake Code: ");
                    String cakeCode = scanner.next();
                    scanner.nextLine(); 
            
                    
                    for (int i = 0; i < system.cakes.size(); i++) {
                        if (system.cakes.get(i).getCakeCode().equals(cakeCode)) {
                            System.out.println("Error: Cake code already exists!");
                            return;
                        }
                    }
            
                    System.out.print("Enter Cake Name: ");
                    String cakeName = scanner.nextLine(); 
            
                    System.out.print("Enter Cake Price: ");
                    double cakePrice = scanner.nextDouble();
                    scanner.nextLine(); 
            
                    Cake cake = new Cake(cakeCode, cakeName, cakePrice);
                    system.addCake(cake);
                    System.out.println("Cake added successfully.");
                } catch (Exception e) {
                    System.out.println("Error: Invalid input. Please enter valid data.");
                    scanner.nextLine(); 
                }
            }
            
            private static void updateCake(CakeOrderingSystem system, Scanner scanner) {
                try {
                    System.out.print("Enter Cake Code to update: ");
                    String cakeCode = scanner.next();
            
                    Cake existingCake = null;
            
                    
                    for (int i = 0; i < system.cakes.size(); i++) {
                        if (system.cakes.get(i).getCakeCode().equals(cakeCode)) { 
                            existingCake = system.cakes.get(i);
                            break; 
                        }
                    }
            
                    if (existingCake == null) {
                        System.out.println("Error: Cake with code '" + cakeCode + "' not found.");
                        return;
                    }
            
                    scanner.nextLine(); 
            
                    System.out.print("Enter new Cake Name: ");
                    String cakeName = scanner.nextLine(); 
            
                    System.out.print("Enter new Cake Price: ");
                    double cakePrice = scanner.nextDouble();
                    scanner.nextLine(); 
            
                    Cake updatedCake = new Cake(cakeCode, cakeName, cakePrice);
                    system.updateCake(cakeCode, updatedCake);
            
                    System.out.println("Cake updated successfully.");
                } catch (Exception e) {
                    System.out.println("Error: Invalid input. Please enter valid data.");
                    scanner.nextLine(); 
                }
            }
            
            private static void deleteCake(CakeOrderingSystem system, Scanner scanner) {
                try {
                    System.out.print("Enter Cake Code to delete: ");
                    String cakeCode = scanner.next();
            
                    boolean cakeFound = false;
            
                    
                    for (int i = 0; i < system.cakes.size(); i++) {
                        if (system.cakes.get(i).getCakeCode().equals(cakeCode)) {
                            cakeFound = true;
                            break; 
                        }
                    }
            
                    if (cakeFound) {
                        system.deleteCake(cakeCode);
                        System.out.println("Cake deleted successfully.");
                    } else {
                        System.out.println("Error: Cake with code '" + cakeCode + "' not found.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Invalid input. Please enter a valid Cake Code.");
                    scanner.nextLine(); 
                }
            }
                            
        

        public static void manageCustomersMenu(CakeOrderingSystem system, Scanner scanner) {
            int option;
            do {
                System.out.println("** Customer Menu **");
                System.out.println("1. Create Customer");
                System.out.println("2. Update Customer");
                System.out.println("3. Delete Customer");
                System.out.println("4. View all Customers");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter option: ");
                option = scanner.nextInt();
        
                switch (option) {
                    case 1:
                        createCustomer(system, scanner);
                        break;
                    case 2:
                        updateCustomer(system, scanner);
                        break;
                    case 3:
                        deleteCustomer(system, scanner);
                        break;
                    case 4:
                        system.viewCustomers();
                        break;
                
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } while (option != 5);
        }
        private static void createCustomer(CakeOrderingSystem system, Scanner scanner) {
            try {
                System.out.print("Enter Customer ID: ");
                int customerId = scanner.nextInt();
                scanner.nextLine();  
        
                
                for (int i = 0; i < system.customers.size(); i++) {
                    if (system.customers.get(i).getCustomerId() == customerId) {
                        System.out.println("Error: Customer ID already exists!");
                        return;
                    }
                }
        
                System.out.print("Enter Customer Name: ");
                String customerName = scanner.nextLine();  
        
                System.out.print("Enter Customer Address: ");
                String customerAddress = scanner.nextLine(); 
        
                int contactNumber;
                while (true) {
                    System.out.print("Enter  Customer Contact Number (8 digits): ");
                    String contactInput = scanner.next();
        
                   
                    if (contactInput.matches("\\d{8}")) {
                        contactNumber = Integer.parseInt(contactInput);
                        break;
                    } else {
                        System.out.println("Error: Contact number must be exactly 8 digits.");
                    }
                }
        
                Customer customer = new Customer(customerId, customerName, customerAddress, contactNumber);
                system.addCustomer(customer);
                System.out.println("Customer added successfully.");
                
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter the correct data format.");
                scanner.nextLine(); 
            }
        }
        
        private static void updateCustomer(CakeOrderingSystem system, Scanner scanner) {
            try {
                System.out.print("Enter Customer ID to update: ");
                int customerId = scanner.nextInt();
        
                Customer existingCustomer = null;
        
               
                for (int i = 0; i < system.customers.size(); i++) {
                    if (system.customers.get(i).getCustomerId() == customerId) { 
                        existingCustomer = system.customers.get(i);
                        break; 
                    }
                }
        
                if (existingCustomer == null) {
                    System.out.println("Error: Customer with ID '" + customerId + "' not found.");
                    return;
                }
        
                scanner.nextLine(); 
        
                System.out.print("Enter new Customer Name: ");
                String customerName = scanner.nextLine(); 
        
                System.out.print("Enter new Customer Address: ");
                String customerAddress = scanner.nextLine(); 

                int contactNumber;
                while (true) {
                    System.out.print("Enter new Customer Contact Number (8 digits): ");
                    String contactInput = scanner.next();
        
                    
                    if (contactInput.matches("\\d{8}")) {
                        contactNumber = Integer.parseInt(contactInput);
                        break;
                    } else {
                        System.out.println("Error: Contact number must be exactly 8 digits.");
                    }
                }
        
                Customer updatedCustomer = new Customer(customerId, customerName, customerAddress, contactNumber);
                system.updateCustomer(customerId, updatedCustomer);
                System.out.println("Customer updated successfully.");
                
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter valid data.");
                scanner.nextLine(); 
            }
        }
        
        private static void deleteCustomer(CakeOrderingSystem system, Scanner scanner) {
            try {
                System.out.print("Enter Customer ID to delete: ");
                int customerId = scanner.nextInt();
        
                boolean customerFound = false;
        
               
                for (int i = 0; i < system.customers.size(); i++) {
                    if (system.customers.get(i).getCustomerId() == customerId) {
                        customerFound = true;
                        break; 
                    }
                }
        
                if (customerFound) {
                    system.deleteCustomer(customerId);
                    System.out.println("Customer deleted successfully.");
                } else {
                    System.out.println("Error: Customer with ID '" + customerId + "' not found.");
                }
                
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a valid numeric Customer ID.");
                scanner.nextLine(); 
            }
        }
        
     
    

        private static void manageOrdersMenu(CakeOrderingSystem system, Scanner scanner) {
            int option;
            do {
                System.out.println("** Order Menu **");
                System.out.println("1. Create Order");
                System.out.println("2. Cancel Order");
                System.out.println("3. View all Orders");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter option: ");
        
                
                try {
                    option = scanner.nextInt();
                    scanner.nextLine(); 
        
                    switch (option) {
                        case 1:
                            createOrder(system, scanner);
                            break;
                        case 2:
                            cancelOrder(system, scanner);
                            break;
                        case 3:
                            system.viewOrders();
                            break;
                        case 4:
                            System.out.println("Returning to Main Menu...");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); 
                    option = 0; 
                }
            } while (option != 4);
        }
        
        private static void createOrder(CakeOrderingSystem system, Scanner scanner) {
            System.out.print("Enter Order Date (YYYY-MM-DD): ");
            String dateStr = scanner.nextLine();
            Date orderDate;
        
            try {
               
                LocalDate localDate = LocalDate.parse(dateStr);
        
                
                if (!isValidDate(localDate)) {
                    System.out.println("Invalid date. Please enter a valid date.");
                    return;
                }
        
            
                orderDate = java.sql.Date.valueOf(localDate);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
                return;
            }
        
            System.out.print("Enter Customer ID: ");
            String customerInput = scanner.nextLine();
            int customerId;
        
            try {
                customerId = Integer.parseInt(customerInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Customer ID must be a number.");
                return;
            }
        
            Customer customer = null;
            for (Customer c : system.customers) {
                if (c.getCustomerId() == customerId) {
                    customer = c;
                    break;
                }
            }
        
            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }
        
            System.out.print("Enter Cake Code: ");
            String cakeCode = scanner.nextLine();
            Cake cake = null;
        
            for (Cake c : system.cakes) {
                if (c.getCakeCode().equals(cakeCode)) {
                    cake = c;
                    break;
                }
            }
        
            if (cake == null) {
                System.out.println("Cake not found.");
                return;
            }
        
            int orderId = system.orders.size() + 5001;
            Order order = new Order(orderId, customer, cake, orderDate);
            system.makeOrder(order);
            System.out.println("Cake " + cakeCode + " ordered, Order ID is " + orderId);
        }
        
        
        private static boolean isValidDate(LocalDate date) {
            try {
                
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
        }
        private static void cancelOrder(CakeOrderingSystem system, Scanner scanner) {
            int orderId = -1;
        
           
            try {
                System.out.print("Enter Order ID to cancel: ");
                orderId = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Invalid input. Order ID must be a number.");
                scanner.nextLine(); 
                return;
            }
        
            boolean orderFound = false;
        
            
            for (int i = 0; i < system.orders.size(); i++) {
                if (system.orders.get(i).getOrderId() == orderId) {
                    orderFound = true;
                    break;
                }
            }
        
            if (orderFound) {
                system.cancelOrder(orderId);
                System.out.println("Order canceled successfully.");
            } else {
                System.out.println("Error: Order with ID '" + orderId + "' not found.");
            }
        }
        

    private static void generateReportsMenu(CakeOrderingSystem system, Scanner scanner) {
        int option;
        do {
            System.out.println("** Reports Menu **");
            System.out.println("1. Generate Report by Date");
            System.out.println("2. Generate Report by Cake");
            System.out.println("3. Generate Report by Customer");
            System.out.println("4. View Total Orders Report");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter option: ");
    
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine(); 
    
            switch (option) {
                case 1:
                   
        Date validDate = null;

        while (validDate == null) {
            System.out.println("\n===== REPORT BY DATE =====");
            System.out.print("Enter date (YYYY-MM-DD): ");
            String dateStr = scanner.nextLine();

            try {
               
                LocalDate parsedDate = LocalDate.parse(dateStr);
                
                
                validDate = Date.valueOf(parsedDate);
                system.generateReportByDate(validDate);
           
                
                
                
            } catch (DateTimeParseException e) {
                System.out.println("This Date does not exists. Please enter a valid date (YYYY-MM-DD).");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date. Please enter a correct date.");
            }

            
              
                
        }


        break;
    
                case 2:
                System.out.println("\n===== REPORT BY CAKE =====");
                    System.out.print("Enter Cake Code: ");
                    String cakeCode = scanner.nextLine();
                    system.generateReportByCake(cakeCode);
                    break;
    
                case 3:
                System.out.println("\n===== REPORT BY CUSTOMER =====");
                    System.out.print("Enter Customer ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid Customer ID.");
                        scanner.next();
                    }
                    int customerId = scanner.nextInt();
                    scanner.nextLine(); 
                    system.generateReportByCustomer(customerId);
                    break;
    
                case 4:
                    System.out.println("Total Orders Report:");
                    system.generateTotalOrderReport();
                    break;
    
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);
    }
    
}





















