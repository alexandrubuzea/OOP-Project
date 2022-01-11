package output;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Gift;
import enums.Category;

/**
 * A class which represents the output data for one gift.
 */
public class GiftOutputData {
    /**
     * The name of the gift.
     */
    @JsonProperty("productName")
    private String name;

    /**
     * A getter for the name field.
     * @return a String which represents the name of the given field.
     */
    public String getName() {
        return name;
    }

    /**
     * A setter for the name field.
     * @param name a String which represents the new name of the gift (for jackson library).
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * The price of the gift.
     */
    @JsonProperty("price")
    private double price;

    /**
     * A getter for the price field.
     * @return a double value representing the price of the gift.
     */
    public double getPrice() {
        return price;
    }

    /**
     * A setter for the price field.
     * @param price a double value representing the new price.
     */
    public void setPrice(final double price) {
        this.price = price;
    }

    /**
     * The category of the gift.
     */
    @JsonProperty("category")
    private Category category;

    /**
     * A getter for the category field.
     * @return the category of the current gift.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * A setter for the category field.
     * @param category the new category of the gift.
     */
    public void setCategory(final Category category) {
        this.category = category;
    }

    /**
     * A constructor which uses a Gift instance in order to create output for a gift.
     * @param gift
     */
    public GiftOutputData(final Gift gift) {
        this.category = gift.getCategory();
        this.name = gift.getName();
        this.price = gift.getPrice();
    }
}
