package output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OutputData {
    @JsonProperty("annualChildren")
    private List<RoundData> rounds;

    public List<RoundData> getRounds() {
        return rounds;
    }

    public void setRounds(List<RoundData> rounds) {
        this.rounds = rounds;
    }

    public OutputData() { }
}
