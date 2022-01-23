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

    /**
     * A static method which returns a list containing all the possible values of
     * enum data type.
     * @return the list of available cities.
     */
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

    /**
     * A method which returns the string associated to the city (the name of the city)
     * @return the name of the given city.
     */
    public String toString() {
        return value;
    }
}
