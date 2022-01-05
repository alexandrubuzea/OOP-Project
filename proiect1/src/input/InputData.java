package input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InputData {
    @JsonProperty("numberOfYears")
    private int numberOfYears;

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    @JsonProperty("santaBudget")
    private double santaBudget;

    public double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(double santaBudget) {
        this.santaBudget = santaBudget;
    }

    @JsonProperty("initialData")
    private InitialData initialData;

    public InitialData getInitialData() {
        return initialData;
    }

    public void setInitialData(InitialData initialData) {
        this.initialData = initialData;
    }

    @JsonProperty("annualChanges")
    private List<ChangeInputData> changes;

    public List<ChangeInputData> getChanges() {
        return changes;
    }

    public void setChanges(List<ChangeInputData> changes) {
        this.changes = changes;
    }

    public InputData() { }
}
