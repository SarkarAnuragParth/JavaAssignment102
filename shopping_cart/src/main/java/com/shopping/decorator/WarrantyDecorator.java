
package com.shopping.decorator;

import com.shopping.Entities.Product;

public class WarrantyDecorator extends ProductDecorator {
    private static final int WARRANTY_PRICE = 300;

    public WarrantyDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + WARRANTY_PRICE;
    }
}