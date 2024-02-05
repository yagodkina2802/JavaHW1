package ru.gb.oop;

public class Product{
    private final double price;
    private int rating;
    private int count;
    private static int counterId = 0;
    private final int id;
    private final String nameProduct;

    Product(String nameProduct, int price, int count) {
        counterId++;
        this.id = counterId;
        this.nameProduct = nameProduct;
        this.price = price;
        this.count = count;
    }


    double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public int getCount() {
        return count;
    }
    int getCounterId() {
        return counterId;
    }

    int getId() {
        return id;
    }
    String getNameProduct() {
        return nameProduct;
    }
    @Override
    public String toString() {
        return "Продукт {" +
                "id = '" + this.id + "', " +
                "название = '" + this.nameProduct + "', " +
                "цена = '" + this.price + "', " +
                "рейтинг = '" + this.rating + "', " +
                "количество = '" + this.count + '\'' +
                '}';
    }

    void saleProduct(int count) {
        this.rating++;
        this.count -= count;
    }
}
