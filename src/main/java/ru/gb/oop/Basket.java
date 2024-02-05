package ru.gb.oop;

import java.util.HashMap;
import java.util.Map;

public class Basket{
    private static int counterId = 0;
    private final int id;
    private final Map<Integer, Integer> buyProducts = new HashMap<>();
    Basket(){
        counterId++;
        this.id = counterId;
    }

        int getId() {
            return id;
        }

        Map<Integer, Integer> getProducts() {
            return buyProducts;
        }

        void addInBasket(int productId, int count) {
            buyProducts.put(productId, count);
        }

        @Override
        public String toString() {
            return "Корзина {" +
                    "id = '" + id + "', " +
                    "куплены товары с id = '" + buyProducts + '\'' +
                    '}';
        }
}

