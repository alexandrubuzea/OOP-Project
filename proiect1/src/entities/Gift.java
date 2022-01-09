package entities;

import enums.Category;
import input.GiftInputData;

/**
 * A class which is used to model a gift from the santa database (and its relevant attributes,
 * such as name, price and category).
 */
public class Gift {
    /**
     * The name field of the gift
     */
    private final String name;

    /**
     * A getter for the name field.
     * @return the desired name/description of the gift
     */
    public String getName() {
        return name;
    }

    /**
     * The price filed of the gift, which is a double value.
     */
    private final double price;

    /**
     * A getter for the price field.
     * @return a double value representing the price of the gift.
     */
    public double getPrice() {
        return price;
    }

    /**
     * The category field of a gift (which is an enum value, Category type)
     */
    private final Category category;

    /**
     * A getter for the category field.
     * @return and enum value (Category type) representing the category of the gift.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * A constructor for a gift entity using the input data (GiftInputData type)
     * @param gift
     */
    public Gift(final GiftInputData gift) {
        this.name = gift.getName();
        this.price = gift.getPrice();
        this.category = gift.getCategory();
    }

    /**
     * A copy constructor for a gift entity, which performs deep copy over all fields.
     * @param gift the entity which needs to be copied.
     */
    public Gift(final Gift gift) {
        this.name = gift.name;
        this.category = gift.category;
        this.price = gift.getPrice();
    }
}
