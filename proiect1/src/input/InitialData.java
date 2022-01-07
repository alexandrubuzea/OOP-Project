package input;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class InitialData {
    @JsonProperty("children")
    private List<ChildInputData> childrenInputData;

    public List<ChildInputData> getChildrenInputData() {
        return childrenInputData;
    }

    public void setChildrenInputData(List<ChildInputData> childrenInputData) {
        this.childrenInputData = childrenInputData;
    }

    @JsonProperty("santaGiftsList")
    private List<GiftInputData> gifts;

    public List<GiftInputData> getGifts() {
        return gifts;
    }

    public void setGifts(List<GiftInputData> gifts) {
        this.gifts = gifts;
    }

    public InitialData() { }
}
