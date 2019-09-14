package consolecrm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private String orderNumber;
    private Product product;

    public String getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(String newOrderNumber) {
        this.orderNumber = newOrderNumber;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(String productDescription) throws Exception {
        Product product = new Product();
        this.product = product.searchProductInFile(productDescription);
    }
    
    public void createOrderInFile (Order order){
        try (FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Order.txt", true);
                
                BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write("\n" + order.getOrderNumber() + "#" + order.getProduct().getDescription());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
    public Order searchOrderInFile(String orderNumber) throws Exception{
        Order order = new Order();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Order.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            int c = 0;
            
            while ((line = br.readLine()) != null) {
                if(line.contains(orderNumber)){
                    c++;
                    String[] ordertext = line.split("#");
                    order.setOrderNumber(ordertext[0]);
                    order.setProduct(ordertext[1]);
                }
            }
            
            if (c == 0)
                    throw new Exception("Order not found in the database!");
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return order;
    }
    
    public void updateOrderInFile(String orderNumber, String newProductDescription) throws Exception {
        Order order = new Order();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Order.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            List <String> ordersInFile = new ArrayList<String>();
            Boolean foundOrder = false;
            
            while ((line = br.readLine()) != null) {
                if(!line.contains(orderNumber)){
                    ordersInFile.add(line);
                }
                else
                    foundOrder = true;
            }
            
            if (foundOrder)
                ordersInFile.add(orderNumber + "#" + newProductDescription);
            
            PrintWriter cleaner = new PrintWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Order.txt");
            cleaner.print("");
            cleaner.close();

            
            try(FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Order.txt", true);
                    
                    BufferedWriter bw = new BufferedWriter(writer)) {
                
                for(String text : ordersInFile){
                    bw.write("\n" + text);
                }
                    
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
    public void deleteOrderInFile(String orderNumber) throws Exception {
        Order order = new Order();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Order.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            List <String> ordersInFile = new ArrayList<String>();
            
            while ((line = br.readLine()) != null) {
                if(!line.contains(orderNumber)){
                    ordersInFile.add(line);
                }
            }
            
            PrintWriter cleaner = new PrintWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Order.txt");
            cleaner.print("");
            cleaner.close();

            
            try(FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Order.txt", true);
                    
                    BufferedWriter bw = new BufferedWriter(writer)) {
                
                for(String text : ordersInFile){
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
