package ru.gb.oop;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private final Category[] categories;
    private final Map<String, User> users;

    Store() {
        this.categories = new Category[2];
        this.users = new HashMap<>();

        Category categoryFruit = new Category("Фрукты");
        Product[] fruits = new Product [] {
                new Product("Лимон", 50, 200),
                new Product("Яблоко", 10, 200),
                new Product("Груша", 20, 40)
        };
        for (Product fruit: fruits) {
            categoryFruit.addInCategory(fruit.getId(), fruit);
        }

        Category categoryVegetables = new Category("Овощи");
        Product[] vegetables = new Product []{
                new Product("Помидор", 10, 200),
                new Product("Огурец", 70, 300),
                new Product("Капуста", 50, 100)
        };

        for (Product vegetable: vegetables) {
            categoryVegetables.addInCategory(vegetable.getId(), vegetable);
        }

        categories[0] = categoryFruit;
        categories[1] = categoryVegetables;

        users.put("Настя", new User ("Nastya", "1234"));
        users.put("Лиза", new User("Liza", "4321"));
        users.put("Петя", new User("Petya", "4567"));
    }

    void marketing(){
        printStore();

        System.out.println("Продано:");
        this.buyProduct("Настя", 1, 20);
        this.buyProduct("Лиза", 3, 10);
        this.buyProduct("Петя", 6, 2);
        System.out.println();

        printStore();
    }

    void printStore() {
        System.out.println("Магазин:");
        for (Category category : this.categories) {
            System.out.println(category);
        }
    }

    void buyProduct(String userName, int productId, int count) {
        Product product = this.getProduct(productId);
        System.out.print(userName +
                " пробовал купить товар с id = " + productId +
                " в количестве " + count + " штук. "
        );
        if (product == null) {
            System.out.println("Но продукт не существует. Пока что.");
        } else if (product.getCount() < count) {
            System.out.println("Но такого количества '" + product.getNameProduct() + "' в магазине нет. Пока что.");
        } else {
            this.users.get(userName).getBasket().addInBasket(productId, count);
            product.saleProduct(count);
            System.out.println("И купил " + count + " '" + product.getNameProduct() + "'!");
        }
    }

    Product getProduct(int productId) {
        for (Category category : this.categories) {
            Product product = category.getProduct(productId);
            if (product != null) {
                return product;
            }
        }
        return null;
    }
}

