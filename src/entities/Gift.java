package entities;

import enums.Category;
import input.GiftInputData;

import java.util.Objects;

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

    /**
     * The equals method from Object class overriden in order to use hashmaps in a correct
     * way. (added Javadoc only for checkstyle - I know it is not recommended to add Javadoc
     * for the overriden methods).
     * @param o the object to which the current instance compares to
     * @return a boolean value representing the result of the comparison.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Gift)) {
            return false;
        }
        Gift gift = (Gift) o;
        return Double.compare(gift.getPrice(), getPrice()) == 0 && Objects.equals(getName(),
                gift.getName()) && getCategory() == gift.getCategory();
    }

    /**
     * The hashCode method from Object class overriden in order to use hashmaps in a correct
     * way. (added Javadoc only for checkstyle - I know it is not recommended to add Javadoc
     * for the overriden methods).
     * @return an integer value representing the value of the hashing function over the existing
     * fields.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getCategory());
    }
}
