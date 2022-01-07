package output;

import com.fasterxml.jackson.annotation.JsonProperty;
import roundStatus.Round;

import java.util.ArrayList;
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

    public RoundData(Round round) {
        this.children = new ArrayList<>(round.getGlobalStatus().values().stream().map(ChildOutputData::new).toList());
    }
}
