package consolecrm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    
    private String name;
    private String code;
    private String state;
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String newCode) {
        this.code = newCode;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String newState) {
        this.state = newState;
    }
    
    //CRUD section of the class
    public void createCustomerInFile (Customer customer){
        try (FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Customer.txt", true);
                
            BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write("\n" + customer.getName() + "#" + customer.getCode() + "#"
            + customer.getState());
	} catch (IOException e) {
		System.err.format("IOException: %s%n", e);
	}
    }
    
    public Customer searchCustomerInFile(String name) throws Exception{
        Customer customer = new Customer();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Customer.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            int c = 0;
            
            while ((line = br.readLine()) != null) {
                if(line.contains(name)){
                    c++;
                    String[] customertext = line.split("#");
                    customer.setName(customertext[0]);
                    customer.setCode(customertext[1]);
                    customer.setState(customertext[2]);
                }
            }
            
            if (c == 0)
                    throw new Exception("Customer not found in the database!");
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return customer;
    }
    
    public void updateCustomerInFile(String name, String newCode, String newState) throws Exception {
        Customer customer = new Customer();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Customer.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            List <String> customersInFile = new ArrayList<String>();
            Boolean foundCustomer = false;
            
            while ((line = br.readLine()) != null) {
                if(!line.contains(name)){
                    customersInFile.add(line);
                }
                else
                    foundCustomer = true;
            }
            
            if (foundCustomer)
                customersInFile.add(name + "#" + newCode + "#"+ newState);
            
            PrintWriter cleaner = new PrintWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Customer.txt");
            cleaner.print("");
            cleaner.close();

            
            try(FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Customer.txt", true);
                    
                    BufferedWriter bw = new BufferedWriter(writer)) {
                
                for(String text : customersInFile){
                    bw.write("\n" + text);
                }
                    
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
    public void deleteCustomerInFile(String name) throws Exception {
        Customer customer = new Customer();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Customer.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            List <String> customersInFile = new ArrayList<String>();
            
            while ((line = br.readLine()) != null) {
                if(!line.contains(name)){
                    customersInFile.add(line);
                }
            }
            
            PrintWriter cleaner = new PrintWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Customer.txt");
            cleaner.print("");
            cleaner.close();

            
            try(FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Customer.txt", true);
                    
                    BufferedWriter bw = new BufferedWriter(writer)) {
                
                for(String text : customersInFile){
                    bw.write("\n" + text);
                }
                    
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
