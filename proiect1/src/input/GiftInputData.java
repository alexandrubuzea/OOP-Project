package input;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;

/**
 * A class used to retain the input data for a gift parsed from a JSON file with jackson library.
 */
public class GiftInputData {
    /**
     * The name of the gift
     */
    @JsonProperty("productName")
    private String name;

    /**
     * A getter for the name of the gift
     * @return the name of the gift
     */
    public String getName() {
        return name;
    }

    /**
     * A setter for the name of the gift (for jackson library)
     * @param name the name of the gift, given as a String
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * The price of a gift
     */
    @JsonProperty("price")
    private double price;

    /**
     * A getter for the price field of the gift input data.
     * @return a double value representing the price of the gift.
     */
    public double getPrice() {
        return price;
    }

    /**
     * A setter for the price of a gift.
     * @param price the new price of the gift
     */
    public void setPrice(final double price) {
        this.price = price;
    }

    /**
     * The category field of a gift.
     */
    @JsonProperty("category")
    private Category category;

    /**
     * A getter for the gift category
     * @return the category of the gift, given as an enum (Category type)
     */
    public Category getCategory() {
        return category;
    }

    /**
     * A setter for the gift category.
     * @param category the category given as an enum (Category type)
     */
    public void setCategory(final Category category) {
        this.category = category;
    }

    /**
     * A default constructor for checkstyle.
     */
    public GiftInputData() { }
}
