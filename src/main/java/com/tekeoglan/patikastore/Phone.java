package com.tekeoglan.patikastore;

class Phone extends Product {
    PhoneProperties properties;

    Phone(Product product, PhoneProperties properties) {
        super(product.id, product.price, product.discount, product.quantity, product.name, product.brand);
        this.properties = properties;
    }

}
