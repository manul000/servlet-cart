package com.study.shop.config;

import com.study.shop.model.Product;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.concurrent.ConcurrentHashMap;

public class CatalogListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        var catalog = new ConcurrentHashMap<Integer, Product>();
        catalog.put(1, new Product(1, "Кофе", "250.00", 10));
        catalog.put(2, new Product(2, "Чай", "150.00", 10));
        catalog.put(3, new Product(3, "Книга", "900.00", 5));
        catalog.put(4, new Product(4, "Блокнот", "120.00", 20));
        catalog.put(5, new Product(5, "Ручка", "50.00", 30));
        event.getServletContext().setAttribute("catalog", catalog);
    }
}
