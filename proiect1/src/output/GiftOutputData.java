package output;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Gift;
import enums.Category;

public class GiftOutputData {
    @JsonProperty("productName")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("price")
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("category")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public GiftOutputData(Gift gift) {
        this.category = gift.getCategory();
        this.name = gift.getName();
        this.price = gift.getPrice();
    }
}
