package consolecrm;

import java.util.Scanner;

public class Menu {
    
    //options to select the screens throug the Menu class
    public static int mainOption = 0;
    public static int customerOption = 0;
    public static int productOption = 0;
    public static int orderOption = 0;
    public static int userOption = 0;
    
    //first section of the Menu class, login page and Main Menu
    public void loginScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        User searchUser = new User();
        
        System.out.print("Please enter your credentials below.\n");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        if(searchUser.isValidUser(username, password))
            this.mainMenu();
        else{
            System.out.print("\nUser not found!\n");
            this.loginScreen();
        }
    }
    
    public void mainMenu() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nSelect the system option:\n");
        System.out.print("1 - Customers\n");
        System.out.print("2 - Products\n");
        System.out.print("3 - Orders\n");
        System.out.print("4 - Users\n");
        
        mainOption = Integer.parseInt(sc.nextLine());
        
        switch (mainOption){
            case 1:
                this.customerMenu();
                break;
            case 2:
                //this.productMenu();
                break;
            case 3:
                //this.orderMenu();
                break;
            case 4:
                this.userMenu();
                break;
        }
    }
    
    // Customer section of the Menu
    public void customerMenu() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nSelect the Customer option:\n");
        System.out.print("1 - Create\n");
        System.out.print("2 - Search\n");
        System.out.print("3 - Update\n");
        System.out.print("4 - Delete\n");
        System.out.print("5 - Main Menu\n");
        
        customerOption = Integer.parseInt(sc.nextLine());
        
        switch (customerOption){
            case 1:
                this.createCustomerScreen();
                break;
            case 2:
                this.searchCustomerScreen();
                break;
            case 3:
                this.updateCustomerScreen();
                break;
            case 4:
                this.deleteCustomerScreen();
                break;
            case 5:
                this.mainMenu();
                break;
        }
    }
    
    public void createCustomerScreen() throws Exception {
        Scanner sc = new Scanner(System.in);
        Customer newcustomer = new Customer();
        
        System.out.print("Name: ");
        newcustomer.setName(sc.nextLine());
        System.out.print("Code: ");
        newcustomer.setCode(sc.nextLine());
        System.out.print("State: ");
        newcustomer.setState(sc.nextLine());
        
        newcustomer.createCustomerInFile(newcustomer);
        
        this.customerMenu();
    }
    
    public void searchCustomerScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Name: ");
        String searchCustomer = sc.nextLine();
        Customer auxCustomer = new Customer();
        
        try{
        System.out.print(auxCustomer.searchCustomerInFile(searchCustomer).getName() + 
                " - " + auxCustomer.searchCustomerInFile(searchCustomer).getCode() + "\n");
        } catch (Exception e){System.out.print(e);}
            
        this.customerMenu();
    }
    
    public void updateCustomerScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter new Code: ");
        String newCode = sc.nextLine();
        System.out.print("Enter new State: ");
        String newState = sc.nextLine();
        Customer auxCustomer = new Customer();
        
        auxCustomer.updateCustomerInFile(name, newCode, newState);
        this.customerMenu();
    }
    
    public void deleteCustomerScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Name: ");
        String searchCustomer = sc.nextLine();
        Customer auxCustomer = new Customer();
        
        auxCustomer.deleteCustomerInFile(searchCustomer);
        this.customerMenu();
    }
    
    // Product section of the Menu
    public void productMenu() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nSelect the Product option:\n");
        System.out.print("1 - Create\n");
        System.out.print("2 - Search\n");
        System.out.print("3 - Update\n");
        System.out.print("4 - Delete\n");
        System.out.print("5 - Main Menu\n");
        
        productOption = Integer.parseInt(sc.nextLine());
        
        switch (productOption){
            case 1:
                this.createProductScreen();
                break;
            case 2:
                this.searchProductScreen();
                break;
            case 3:
                this.updateProductScreen();
                break;
            case 4:
                this.deleteProductScreen();
                break;
            case 5:
                this.mainMenu();
                break;
        }
    }
    
    public void createProductScreen() throws Exception {
        Scanner sc = new Scanner(System.in);
        Product newproduct = new Product();
        
        System.out.print("Description: ");
        newproduct.setDescription(sc.nextLine());
        System.out.print("Number: ");
        newproduct.setNumber(Integer.parseInt(sc.nextLine()));
        System.out.print("Price: ");
        newproduct.setPrice(Double.parseDouble(sc.nextLine()));
        
        newproduct.createProductInFile(newproduct);
        
        this.productMenu();
    }
    
    public void searchProductScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Description: ");
        String searchProduct = sc.nextLine();
        Product auxProduct = new Product();
        
        try{
        System.out.print(auxProduct.searchProductInFile(searchProduct).getDescription() + 
                " - " + auxProduct.searchProductInFile(searchProduct).getNumber() + "\n");
        } catch (Exception e){System.out.print(e);}
            
        this.productMenu();
    }
    
    public void updateProductScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Description: ");
        String description = sc.nextLine();
        System.out.print("Enter new Number: ");
        int newNumber = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new Price: ");
        double newPrice = Double.parseDouble(sc.nextLine());
        Product auxProduct = new Product();
        
        auxProduct.updateProductInFile(description, newNumber, newPrice);
        this.productMenu();
    }
    
    public void deleteProductScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Description: ");
        String searchProduct = sc.nextLine();
        Product auxProduct = new Product();
        
        auxProduct.deleteProductInFile(searchProduct);
        this.productMenu();
    }
    
        // Order section of the Menu
    public void orderMenu() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nSelect the Order option:\n");
        System.out.print("1 - Create\n");
        System.out.print("2 - Search\n");
        System.out.print("3 - Update\n");
        System.out.print("4 - Delete\n");
        System.out.print("5 - Main Menu\n");
        
        orderOption = Integer.parseInt(sc.nextLine());
        
        switch (orderOption){
            case 1:
                this.createOrderScreen();
                break;
            case 2:
                this.searchOrderScreen();
                break;
            case 3:
                this.updateOrderScreen();
                break;
            case 4:
                this.deleteOrderScreen();
                break;
            case 5:
                this.mainMenu();
                break;
        }
    }
    
    public void createOrderScreen() throws Exception {
        Scanner sc = new Scanner(System.in);
        Order neworder = new Order();
        
        System.out.print("Order Number: ");
        neworder.setOrderNumber(sc.nextLine());
        System.out.print("Product: ");
        neworder.setProduct(sc.nextLine());
        
        neworder.createOrderInFile(neworder);
        
        this.orderMenu();
    }
    
    public void searchOrderScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Order Number: ");
        String searchOrder = sc.nextLine();
        Order auxOrder = new Order();
        
        try{
        System.out.print(auxOrder.searchOrderInFile(searchOrder).getOrderNumber() + 
                " - " + auxOrder.searchOrderInFile(searchOrder).getProduct().getDescription() + "\n");
        } catch (Exception e){System.out.print(e);}
            
        this.orderMenu();
    }
    
    public void updateOrderScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Order Number: ");
        String orderNumber = sc.nextLine();
        System.out.print("Enter new Product: ");
        String newProductDescription = sc.nextLine();
        Order auxOrder = new Order();
        
        auxOrder.updateOrderInFile(orderNumber, newProductDescription);
        this.orderMenu();
    }
    
    public void deleteOrderScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Order Number: ");
        String searchOrder = sc.nextLine();
        Order auxOrder = new Order();
        
        auxOrder.deleteOrderInFile(searchOrder);
        this.orderMenu();
    }
    
    // User section of the Menu
    public void userMenu() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nSelect the User option:\n");
        System.out.print("1 - Create\n");
        System.out.print("2 - Search\n");
        System.out.print("3 - Update\n");
        System.out.print("4 - Delete\n");
        System.out.print("5 - Main Menu\n");
        
        userOption = Integer.parseInt(sc.nextLine());
        
        switch (userOption){
            case 1:
                this.createUserScreen();
                break;
            case 2:
                this.searchUserScreen();
                break;
            case 3:
                this.updateUserScreen();
                break;
            case 4:
                this.deleteUserScreen();
                break;
            case 5:
                this.mainMenu();
                break;
        }
    }
    
    public void createUserScreen() throws Exception {
        Scanner sc = new Scanner(System.in);
        User newuser = new User();
        
        System.out.print("Username: ");
        newuser.setUserName(sc.nextLine());
        System.out.print("Password: ");
        newuser.setPassword(sc.nextLine());
        System.out.print("Select permission: ");
        newuser.setPermission(Integer.parseInt(sc.nextLine()));
        
        newuser.createUserInFile(newuser);
        
        this.userMenu();
    }
    
    public void searchUserScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Username: ");
        String searchUser = sc.nextLine();
        User auxUser = new User();
        
        try{
        System.out.print(auxUser.searchUserInFile(searchUser).getUserName() + 
                " - " + auxUser.searchUserInFile(searchUser).getPermission() + "\n");
        } catch (Exception e){System.out.print(e);}
            
        this.userMenu();
    }
    
    public void updateUserScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter new Password: ");
        String newPassword = sc.nextLine();
        System.out.print("Enter new Permission: ");
        int newPermission = Integer.parseInt(sc.nextLine());
        User auxUser = new User();
        
        auxUser.updateUserInFile(username, newPassword, newPermission);
        this.userMenu();
    }
    
    public void deleteUserScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Username: ");
        String searchUser = sc.nextLine();
        User auxUser = new User();
        
        auxUser.deleteUserInFile(searchUser);
        this.userMenu();
    }
}