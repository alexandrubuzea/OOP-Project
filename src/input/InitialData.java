package input;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * This class contains the initial information about the database: children and available gifts.
 */
public class InitialData {
    /**
     * The initial children list.
     */
    @JsonProperty("children")
    private List<ChildInputData> childrenInputData;

    /**
     * A getter for the children field.
     * @return a list containing the initial children input data.
     */
    public List<ChildInputData> getChildrenInputData() {
        return childrenInputData;
    }

    /**
     * A setter for the children input data - for jackson library
     * @param childrenInputData the new initial children list.
     */
    public void setChildrenInputData(final List<ChildInputData> childrenInputData) {
        this.childrenInputData = childrenInputData;
    }

    /**
     * The initial list of gifts.
     */
    @JsonProperty("santaGiftsList")
    private List<GiftInputData> gifts;

    /**
     * A getter for the initial list of gifts.
     * @return the list of gifts.
     */
    public List<GiftInputData> getGifts() {
        return gifts;
    }

    /**
     * A setter for the initial list of gifts
     * @param gifts the new list of gifts.
     */
    public void setGifts(final List<GiftInputData> gifts) {
        this.gifts = gifts;
    }

    /**
     * A default constructor (for checkstyle)
     */
    public InitialData() { }
}
