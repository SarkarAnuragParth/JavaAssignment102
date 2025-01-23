package com.shopping.Entities;

import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
    private Map<String, Product> products;
    private Map<String, Customer> customers;

    public ShoppingCart(Map<String, Product> products, Map<String, Customer> customers) {
        this.products = products;
        this.customers = customers;
    }

    public void placeOrder() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter customer ID: ");
            String customerId = scanner.nextLine();
            Customer customer = customers.get(customerId);
            if (customer == null) {
                System.out.println("Customer not found!");
                return;
            }

            Order order = new Order(customer);
            while (true) {
                System.out.print("Enter product ID (or 'done' to finish): ");
                String productId = scanner.nextLine();
                if (productId.equals("done")) break;
    
                Product product = products.get(productId);
                if (product == null) {
                    System.out.println("Product not found!");
                    continue;
                }
    
                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                if (quantity > product.getQuantity()) {
                    System.out.println("Quantity not available");
                    continue;
                }
    
                OrderItem orderItem = new OrderItem(product, quantity);
                
                System.out.print("Add gift wrap? (yes/no): ");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    orderItem.addGiftWrap();
                }

                System.out.print("Add delivery? (yes/no): ");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    orderItem.addDelivery();
                }

                order.addItem(orderItem);
                product.setQuantity(product.getQuantity() - quantity);
            }
    
            System.out.println("Order placed successfully!");
            System.out.println("Total amount: " + order.getTotalAmount());
        }
    }
}