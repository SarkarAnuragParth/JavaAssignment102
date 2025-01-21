package com.shopping;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            Map<String, Product> products = CSVReader.readProducts("shopping_cart\\src\\main\\resources\\ProductInfo.csv");
            Map<String, Customer> customers = CSVReader.readCustomers("shopping_cart\\src\\main\\resources\\CustomerInfo.csv");

            ShoppingCart cart = new ShoppingCart(products, customers);
            cart.placeOrder();
        } catch (IOException e) {
            System.out.println("Error reading CSV files: " + e.getMessage());
        }
    }
}