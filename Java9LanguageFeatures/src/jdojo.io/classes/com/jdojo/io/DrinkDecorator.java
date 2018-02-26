// DrinkDecorator.java
package com.jdojo.io;

public abstract class DrinkDecorator extends Drink {
    protected Drink drink;

    @Override
    public String getName() {
        // Append its name after the name of the drink it is decorating
        return drink.getName() + ", " + this.name;
    }

    @Override
    public double getPrice() {
        // Add its price to the price of the drink it is decorating/
        return drink.getPrice() + this.price;
    }

    public Drink getDrink() {
        return drink;
    }
}
