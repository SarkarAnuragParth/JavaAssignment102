
package com.shopping.decorator;

import com.shopping.Entities.Product;

public class DeliveryDecorator extends ProductDecorator {
    private static final int DELIVERY_PRICE = 100;

    public DeliveryDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + DELIVERY_PRICE;
    }
}