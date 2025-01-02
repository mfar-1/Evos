package org.example;

public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer categoryId;

    public Product(Integer id, String name, Integer price, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public Integer payment(int amount){
        return price*amount;
    }

    @Override
    public String toString() {
        return id+" "+name+" price:"+price;
    }
}
