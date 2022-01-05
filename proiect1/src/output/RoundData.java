package output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RoundData {
    @JsonProperty("children")
    private List<ChildOutputData> children;

    public List<ChildOutputData> getChildren() {
        return children;
    }

    public void setChildren(List<ChildOutputData> children) {
        this.children = children;
    }

    public RoundData() { }
}
