package com.tekeoglan.patikastore;

import java.util.Comparator;

class Product {
    String id;
    double price;
    int discount;
    int quantity;
    String name;
    String brand;

    Product(String id, double price, int discount, int quantity, String name, String brand) {
        this.id = id;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.name = name;
        this.brand = brand;
    }

    static class ProductComparatorById implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.id.compareTo(o2.id);
        }
    }

    static class ProductComparatorByBrand implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.brand.compareTo(o2.brand);
        }
    }
}
