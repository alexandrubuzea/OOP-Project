package enums;

import common.Constants;

/**
 * An enum value which is used to assign an age category to an entity who is characterized by age
 */
public enum AgeCategory {
    /**
     * These are all enum's possible values.
     */
    BABY,
    TEEN,
    KID,
    YOUNG_ADULT;

    /**
     * Constructor for checkstyle
     */
    AgeCategory() { }

    /**
     * A method which determines which age category an entity with the given age is in.
     * @param age an integer value representing the age of the entity.
     * @return the age category (as an enum AgeCategory type)
     */
    public static AgeCategory getAgeCategory(final int age) {
        if (age < Constants.MINIMUM_KID_AGE) {
            return BABY;
        } else if (age < Constants.MINIMUM_TEEN_AGE) {
            return KID;
        } else if (age < Constants.MINIMUM_ADULT_AGE) {
            return TEEN;
        } else {
            return YOUNG_ADULT;
        }
    }
}
