package consolecrm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class User {
    
    private String userName;
    private String password;
    public enum Permission{
        SALES, MANAGEMENT, ADMINISTRATOR;
    }
    private Permission permission;
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    
    public String getPermission() {
        return permission.toString();
    }
    
    public void setPermission(int option) {
        switch (option) {
            case 1:
                permission = Permission.SALES;
                break;
            case 2:
                permission = Permission.MANAGEMENT;
                break;
            default:
                permission = Permission.ADMINISTRATOR;
                break;
        }
    }
    
    //CRUD section of the class
    public void createUserInFile (User user){
        try (FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\User.txt", true);
                
            BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write("\n" + user.getUserName() + "#" + user.getPassword() + "#"
            + user.getPermission());
	} catch (IOException e) {
		System.err.format("IOException: %s%n", e);
	}
    }
    
    public User searchUserInFile(String username) throws Exception{
        User user = new User();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\User.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            int c = 0;
            
            while ((line = br.readLine()) != null) {
                if(line.contains(username)){
                    c++;
                    String[] usertext = line.split("#");
                    user.setUserName(usertext[0]);
                    user.setPassword(usertext[1]);
                    user.setPermission(usertext[2].equals("SALES") ? 1 : 
                            usertext[2].equals("MANAGEMENT") ? 2 : 3 );
                }
            }
            
            if (c == 0)
                    throw new Exception("User not found in the database!");
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return user;
    }
    
    public void updateUserInFile(String username, String newPassword, int newPermission) throws Exception {
        User user = new User();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\User.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            List <String> usersInFile = new ArrayList<String>();
            Boolean foundUser = false;
            
            while ((line = br.readLine()) != null) {
                if(!line.contains(username)){
                    usersInFile.add(line);
                }
                else
                    foundUser = true;
            }
            
            if (foundUser)
                usersInFile.add(username + "#" + newPassword + "#"+ (newPermission == 1 ? 
                        "SALES" : newPermission == 2 ? "MANAGEMENT" : "ADMINISTRATOR"));
            
            PrintWriter cleaner = new PrintWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\User.txt");
            cleaner.print("");
            cleaner.close();

            
            try(FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\User.txt", true);
                    
                    BufferedWriter bw = new BufferedWriter(writer)) {
                
                for(String text : usersInFile){
                    bw.write("\n" + text);
                }
                    
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
    public void deleteUserInFile(String username) throws Exception {
        User user = new User();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\User.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            List <String> usersInFile = new ArrayList<String>();
            
            while ((line = br.readLine()) != null) {
                if(!line.contains(username)){
                    usersInFile.add(line);
                }
            }
            
            PrintWriter cleaner = new PrintWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\User.txt");
            cleaner.print("");
            cleaner.close();

            
            try(FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\User.txt", true);
                    
                    BufferedWriter bw = new BufferedWriter(writer)) {
                
                for(String text : usersInFile){
                    bw.write("\n" + text);
                }
                    
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
    public Boolean isValidUser (String username, String password) throws Exception{
        User auxUser = new User();
        
        try{ 
            auxUser = auxUser.searchUserInFile(username);
            ConsoleCRM.loggedUserPermission = auxUser.getPermission();
            
            return auxUser.getUserName().equals(username) 
                && auxUser.getPassword().equals(password);
        } catch(Exception e){
            return false;
        }
    }
}