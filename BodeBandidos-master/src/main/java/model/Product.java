
package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Serializable {
    private int id;
    private String Name;
    private String Category;
    private String mark;
    private double price;
    LocalDate updatedAt, createdAt;

    public Product(int id, String Name, String Category, String mark, double price, LocalDate updatedAt, LocalDate createdAt) {
        this.id = id;
        this.Name = Name;
        this.Category = Category;
        this.mark = mark;
        this.price = price;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
