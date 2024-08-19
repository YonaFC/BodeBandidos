/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.RandomAccesFile;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.Product;

/**
 *
 * @author Carlos Fabricio
 */
public class ProductAccesFile {
    RandomAccessFile flux;
    int countRecords;
    int sizeRecords = 190; 
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    public void openFile(String archive) throws IOException
    {
        flux = new RandomAccessFile(archive,"rw");
        countRecords = (int)Math.ceil((double)flux.length()/(double)sizeRecords);
    }   
    
    public void closeFile() throws IOException
    {
        flux.close();
    }
    
    public void addProduct(Product product) throws IOException
    {
        flux.seek(countRecords*sizeRecords);
        flux.writeInt(product.getId());
        flux.writeUTF(product.getName());
        flux.writeUTF(product.getCategory());
        flux.writeUTF(product.getMark()); // Brand
        flux.writeDouble(product.getPrice());
        flux.writeUTF(product.getUpdatedAt().format(DATE_FORMATTER));
        flux.writeUTF(product.getCreatedAt().format(DATE_FORMATTER));
        countRecords++;
    }
    
    public int getCountRecords(){
        return countRecords;
    }
    
    public int searchByID(int id) throws IOException {
        for (int i = 0; i < getCountRecords(); i++) {
            flux.seek(i*sizeRecords);
            int currentId = flux.readInt();
            if (currentId == id) {
                return i;
        }
    }
        return -1;
    }
    
    public int newId() throws IOException {
        int maxId = 0;
        for (int i = 0; i < getCountRecords(); i++) {
            flux.seek(i * sizeRecords);
            int id = flux.readInt();
            if (id > maxId) {
                maxId = id;
            }
        }
        maxId++;
        
        return maxId;
    }
    
    public void updateProductById(int id, Product product) throws IOException {
        int index = searchByID(id);
        if (index != -1) {
            updateProduct(index, product);
        } else {
            throw new IOException("Cliente con ID " + id + " no encontrado.");
        }
    }
    
    public void deleteProductById(int id) throws IOException {
        List<Product> Product = new ArrayList<>();
       
        for (int i = 0; i < getCountRecords(); ++i) {
            flux.seek(i * sizeRecords);
            if (id != -1) {
                Product product = getProduct(i);
                if (product.getId() != id) {
                    Product.add(product);
                }
            }
        }
        flux.setLength(0);
        countRecords = 0;

        for (Product product : Product){
           flux.seek(flux.length());  
           addProduct(product);
        }
    }
        
    public void updateProduct(int i, Product product) throws IOException {
        flux.seek(i*sizeRecords);

        flux.writeInt(product.getId());
        flux.writeUTF(product.getName());
        flux.writeUTF(product.getCategory());
        flux.writeUTF(product.getMark());
        flux.writeDouble(product.getPrice());
        flux.writeUTF(product.getUpdatedAt().format(DATE_FORMATTER));
        flux.writeUTF(product.getCreatedAt().format(DATE_FORMATTER));
    }
    
    public Product getProduct(int index) throws IOException {
        flux.seek(index * sizeRecords);
        
        int id = flux.readInt();
        String name = flux.readUTF().trim();
        String category = flux.readUTF().trim();
        String brand = flux.readUTF().trim();
        double price = flux.readDouble();
        
        LocalDate updatedAt = LocalDate.parse(flux.readUTF().trim(), DATE_FORMATTER);
        LocalDate createdAt = LocalDate.parse(flux.readUTF().trim(), DATE_FORMATTER);

        return new Product(id,name, category, brand, price, updatedAt, createdAt);
    }
    
    public ArrayList<Product> getProductList() throws IOException {
        ArrayList<Product> products = new ArrayList<>();
        
            for (int i = 0; i < getCountRecords(); ++i) {
                flux.seek(i * sizeRecords);
                Product product = getProduct(i);
                products.add(product);
            }

        return products;
    }
    
}
