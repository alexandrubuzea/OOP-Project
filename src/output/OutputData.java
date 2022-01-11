package output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * A class used to write the output to the JSON file (the JSON output file represents an
 * instance of this kind).
 */
public class OutputData {
    /**
     * The list of rounds which contains the output fro each round.
     */
    @JsonProperty("annualChildren")
    private List<RoundData> rounds;

    /**
     * A getter for the list of rounds.
     * @return the list of rounds containing the desired output.
     */
    public List<RoundData> getRounds() {
        return rounds;
    }

    /**
     * A setter for the list of rounds.
     * @param rounds the new list of rounds containing the desired output.
     */
    public void setRounds(final List<RoundData> rounds) {
        this.rounds = rounds;
    }

    /**
     * A default constructor for the OutputData entity.
     */
    public OutputData() {
        rounds = new ArrayList<>();
    }
}
