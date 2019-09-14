package consolecrm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Product {
    
    private String description;
    private int number;
    private double price;
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int newNumber) {
        this.number = newNumber;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
    
    public void createProductInFile (Product product){
        try (FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Product.txt", true);
                
            BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write("\n" + product.getDescription() + "#" + product.getNumber() + "#"
            + product.getPrice());
	} catch (IOException e) {
		System.err.format("IOException: %s%n", e);
	}
    }
    
    public Product searchProductInFile(String description) throws Exception{
        Product product = new Product();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Product.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            int c = 0;
            
            while ((line = br.readLine()) != null) {
                if(line.contains(description)){
                    c++;
                    String[] producttext = line.split("#");
                    product.setDescription(producttext[0]);
                    product.setNumber(Integer.parseInt(producttext[1]));
                    product.setPrice(Double.parseDouble(producttext[2]));
                }
            }
            
            if (c == 0)
                    throw new Exception("Product not found in the database!");
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return product;
    }
    
    public void updateProductInFile(String description, int newNumber, double newPrice) throws Exception {
        Product product = new Product();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Product.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            List <String> productsInFile = new ArrayList<String>();
            Boolean foundProduct = false;
            
            while ((line = br.readLine()) != null) {
                if(!line.contains(description)){
                    productsInFile.add(line);
                }
                else
                    foundProduct = true;
            }
            
            if (foundProduct)
                productsInFile.add(description + "#" + newNumber + "#"+ newPrice);
            
            PrintWriter cleaner = new PrintWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Product.txt");
            cleaner.print("");
            cleaner.close();

            
            try(FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Product.txt", true);
                    
                    BufferedWriter bw = new BufferedWriter(writer)) {
                
                for(String text : productsInFile){
                    bw.write("\n" + text);
                }
                    
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
    public void deleteProductInFile(String description) throws Exception {
        Product product = new Product();
        try (FileReader reader = new FileReader("C:\\Users\\joaom\\Desktop\\Lixeira"
                + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Product.txt");
                
                BufferedReader br = new BufferedReader(reader)) {
            String line;
            List <String> productsInFile = new ArrayList<String>();
            
            while ((line = br.readLine()) != null) {
                if(!line.contains(description)){
                    productsInFile.add(line);
                }
            }
            
            PrintWriter cleaner = new PrintWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Product.txt");
            cleaner.print("");
            cleaner.close();

            
            try(FileWriter writer = new FileWriter("C:\\Users\\joaom\\Desktop\\Lixeira"
                    + "\\FTT\\EC6\\LP2\\ConsoleCRM\\database\\Product.txt", true);
                    
                    BufferedWriter bw = new BufferedWriter(writer)) {
                
                for(String text : productsInFile){
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
