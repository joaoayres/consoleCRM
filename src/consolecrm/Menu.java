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
                //this.customerMenu();
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
                //update
                break;
            case 4:
                //delete
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
}