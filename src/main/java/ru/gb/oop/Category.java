package ru.gb.oop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Category {
    private final String nameProduct;
    private Map<Integer, Product> products = new HashMap<>();;
    private final int id;
    private static int counterId = 0;
    Category(String nameProduct) {
        counterId++;
        this.id = counterId;
        this.nameProduct = nameProduct;
    }

    Category(String nameProduct, HashMap<Integer, Product> products) {
        counterId++;
        this.id = counterId;
        this.nameProduct = nameProduct;
        this.products = products;
    }


    int getId() {
        return id;
    }


    String getNameProduct() {
        return nameProduct;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    Product getProduct(int productId) {
        return products.get(productId);
    }
    void addInCategory(int productId, Product product) {
        products.put(productId, product);
    }
    void deleteFromCategory(int productId, Product product){
        products.remove(productId, product);
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        String mes = "Категория {" +
                    "id = '" + id + "', " +
                    "название = '" + this.nameProduct + '\'' +
                    "}\n";
            message.append(mes);
            for(Map.Entry<Integer, Product> item : this.products.entrySet()) {
                message.append(item.getValue());
                message.append("\n");
            }

            return message.toString();
        }
    }