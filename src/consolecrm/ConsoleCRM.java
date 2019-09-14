package consolecrm;

public class ConsoleCRM {
    public static String loggedUserPermission;
    
    public static void main(String[] args) throws Exception {
        
        Menu menu = new Menu();
        menu.loginScreen();
    }
}