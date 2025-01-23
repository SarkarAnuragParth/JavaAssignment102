
package com.shopping.decorator;

import com.shopping.Entities.Product;

public class GiftWrapDecorator extends ProductDecorator {
    private static final int GIFT_WRAP_PRICE = 50;

    public GiftWrapDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + GIFT_WRAP_PRICE;
    }
}