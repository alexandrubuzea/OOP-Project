package entities;

import enums.Category;
import input.GiftInputData;

public class Gift {
    private final String name;

    public String getName() {
        return name;
    }

    private final double price;

    public double getPrice() {
        return price;
    }

    private final Category category;

    public Category getCategory() {
        return category;
    }

    public Gift(GiftInputData gift) {
        this.name = gift.getName();
        this.price = gift.getPrice();
        this.category = gift.getCategory();
    }

    public Gift(Gift gift) {
        this.name = gift.name;
        this.category = gift.category;
        this.price = gift.getPrice();
    }
}
