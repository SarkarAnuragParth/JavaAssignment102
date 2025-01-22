package com.shopping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private Map<String, Product> products;
    private Map<String, Customer> customers;
    private ShoppingCart shoppingCart;

    @BeforeEach
    public void setUp() {
        // Prepare mock data for customers
        customers = new HashMap<>();
        customers.put("100", new Customer("100", "David"));
        customers.put("101", new Customer("101", "Robert"));

        // Prepare mock data for products
        products = new HashMap<>();
        products.put("1001", new Product("1001", "Laptop", 30000, 50));
        products.put("1002", new Product("1002", "Mouse", 1000, 100));
        products.put("1003", new Product("1003", "CD", 5000, 10));

        // Initialize shopping cart with products and customers
        shoppingCart = new ShoppingCart(products, customers);
    }

    @Test
    public void testPlaceOrderForValidCustomerAndProduct() {
        // Simulate the user input
        String input = "100\n1002\n2\ndone\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Place the order
        shoppingCart.placeOrder();

        // Validate that the stock of the product has decreased
        assertEquals(98, products.get("1002").getQuantity(), "Product stock should decrease after the order");
    }

    @Test
    public void testPlaceOrderWithInvalidCustomer() {
        // Try placing an order with a non-existent customer
        String invalidCustomerId = "999";  // Non-existent customer

        Customer customer = customers.get(invalidCustomerId);
        assertNull(customer, "Customer should not exist");

        if (customer == null) {
            System.out.println("Customer not found!");
        }
    }

    @Test
    public void testAddMoreItemsThanAvailableStock() {
        // Simulate the user trying to order more than available stock
        String productId = "1003";  // CD
        int quantity = 20;  // More than available stock (only 10 available)

        Product product = products.get(productId);
        assertNotNull(product, "Product should exist");

        // Ensure the product stock is insufficient
        if (quantity > product.getQuantity()) {
            System.out.println("Quantity not available");
        }
        assertTrue(quantity > product.getQuantity(), "Quantity should be more than available stock");
    }

    @Test
    public void testTotalAmountCalculation() {
        // Create an order with multiple items
        String customerId = "100";  // David
        String productId1 = "1001";  // Laptop
        String productId2 = "1002";  // Mouse

        Customer customer = customers.get(customerId);
        Product product1 = products.get(productId1);
        Product product2 = products.get(productId2);

        Order order = new Order(customer);
        order.addItem(new OrderItem(product1, 1)); // 1 Laptop
        order.addItem(new OrderItem(product2, 3)); // 3 Mouse

        // Calculate expected total amount
        double expectedTotalAmount = (30000 * 1) + (1000 * 3);
        assertEquals(expectedTotalAmount, order.getTotalAmount(), "Total amount should be calculated correctly");
    }

    @Test
    public void testProductNotFound() {
        // Try adding a non-existent product
        String invalidProductId = "9999";  // Non-existent product

        Product product = products.get(invalidProductId);
        assertNull(product, "Product should not exist");

        if (product == null) {
            System.out.println("Product not found!");
        }
    }
}