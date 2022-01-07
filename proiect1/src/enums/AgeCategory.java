package enums;

public enum AgeCategory {
    BABY,
    TEEN,
    KID,
    YOUNG_ADULT;

    AgeCategory() { }

    public static AgeCategory getAgeCategory(int age) {
        if (age < 5) {
            return BABY;
        } else if (age < 12){
            return KID;
        } else if (age < 19) {
            return TEEN;
        } else {
            return YOUNG_ADULT;
        }
    }
}
