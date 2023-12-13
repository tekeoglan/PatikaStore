package com.tekeoglan.patikastore;

class NoteBookPc extends Product {
    NoteBookPcProperties properties;

    NoteBookPc(Product product, NoteBookPcProperties properties) {
        super(product.id, product.price, product.discount, product.quantity, product.name, product.brand);
        this.properties = properties;
    }

}
