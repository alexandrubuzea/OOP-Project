package output;

import com.fasterxml.jackson.annotation.JsonProperty;
import roundstatus.Round;

import java.util.ArrayList;
import java.util.List;

/**
 * A class used for output data (for numberOfYears + 1 rounds)
 */
public class RoundData {
    /**
     * The list of children output data (output status for each round for each child)
     */
    @JsonProperty("children")
    private List<ChildOutputData> children;

    /**
     * A getter for the children field.
     * @return the desired children list.
     */
    public List<ChildOutputData> getChildren() {
        return children;
    }

    /**
     * A setter for the children field - the jackson library.
     * @param children the new list of children to be added in output.
     */
    public void setChildren(final List<ChildOutputData> children) {
        this.children = children;
    }

    /**
     * A constructor for the RoundData entity.
     * @param round the status of a round after performing changes and gift assignments.
     */
    public RoundData(final Round round) {
        this.children = new ArrayList<>(round.getGlobalStatus().values().stream()
                        .map(ChildOutputData::new).toList());
    }
}
