package org.example;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    private Integer id=makingID++;
    private String location;
    private Date date;
    private Status currentStatus=Status.IN_ACTIVE;
    private Map<Product,Integer> products=new LinkedHashMap<>();
    private static Integer makingID=100;

    public Order(String location, Date date, Status currentStatus, Map<Product, Integer> products) {
        this.location = location;
        this.date = date;
        this.currentStatus = currentStatus;
        this.products = products;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
