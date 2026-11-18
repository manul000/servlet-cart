package com.study.shop.model;

import java.math.BigDecimal;

public class Product {
    private final int id;
    private final String name;
    private final BigDecimal price;
    private int stock;

    public Product(int id, String name, String price, int stock) {
        this.id = id;
        this.name = name;
        this.price = new BigDecimal(price);
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public synchronized int getStock() {
        return stock;
    }

    public synchronized boolean reserve() {
        if (stock <= 0) return false;
        stock--;
        return true;
    }
}
