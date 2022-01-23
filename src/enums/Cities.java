package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public enum Cities {

    @JsonProperty("Bucuresti")
    BUCURESTI("Bucuresti"),

    @JsonProperty("Constanta")
    CONSTANTA("Constanta"),

    @JsonProperty("Buzau")
    BUZAU("Buzau"),

    @JsonProperty("Timisoara")
    TIMISOARA("Timisoara"),

    @JsonProperty("Cluj-Napoca")
    CLUJ("Cluj-Napoca"),

    @JsonProperty("Iasi")
    IASI("Iasi"),

    @JsonProperty("Craiova")
    CRAIOVA("Craiova"),

    @JsonProperty("Brasov")
    BRASOV("Brasov"),

    @JsonProperty("Braila")
    BRAILA("Braila"),

    @JsonProperty("Oradea")
    ORADEA("Oradea");

    private String value;

    Cities(final String value) {
        this.value = value;
    }

    public static List<Cities> getCities() {
        return new ArrayList<>(List.of(new Cities[]{
                BUCURESTI,
                CONSTANTA,
                BUZAU,
                TIMISOARA,
                CLUJ,
                IASI,
                CRAIOVA,
                BRASOV,
                BRAILA,
                ORADEA
        }));
    }

    public String toString() {
        return value;
    }
}
