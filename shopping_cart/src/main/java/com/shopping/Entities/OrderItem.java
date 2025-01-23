package com.shopping.Entities;

import com.shopping.decorator.WarrantyDecorator;
import com.shopping.decorator.GiftWrapDecorator;

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addGiftWrap() {
        this.product = new GiftWrapDecorator(this.product);
    }

    public void addWarranty() {
        this.product = new WarrantyDecorator(this.product);
    }
}