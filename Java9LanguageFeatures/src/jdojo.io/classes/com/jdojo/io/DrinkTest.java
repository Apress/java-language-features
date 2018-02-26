// DrinkTest.java
package com.jdojo.io;

public class DrinkTest {
    public static void main(String[] args) {
        // Have Whiskey only
        Drink d1 = new Whiskey();
        printReceipt(d1);

        // Have Whiskey with Honey
        Drink d2 = new Honey(new Whiskey());
        printReceipt(d2);

        // Have Vodka with Spices
        Drink d3 = new Spices(new Vodka());
        printReceipt(d3);

        // Have Rum with double Honey and Spices
        Drink d4 = new Spices(new Honey(new Honey(new Rum())));
        printReceipt(d4);
    }

    public static void printReceipt(Drink drink) {
        String name = drink.getName();
        double price = drink.getPrice();
        System.out.println(name + " - $" + price);
    }
}
