package common;

public final class Constants {
    public static final String INPUT_PATH = "tests/test";
    public static final String OUTPUT_PATH = "output/out_";
    public static final String REF_PATH = "ref/ref_test";
    public static final String FILE_EXTENSION = ".json";
    public static final Integer SMALL_TEST_POINTS = 2;
    public static final Integer BIG_TEST_POINTS = 3;
    public static final Integer TESTS_NUMBER = 30;
    public static final Integer MAXIMUM_ERROR_CHECKSTYLE = 30;
    public static final Integer CHECKSTYLE_POINTS = 10;
    public static final Integer TESTS_NUMBER_SMALL = 15;

    // minimum ages (avoid constants hardcoding)
    public static final Integer MINIMUM_ADULT_AGE = 19;
    public static final Integer MINIMUM_TEEN_AGE = 12;
    public static final Integer MINIMUM_KID_AGE = 5;

    public static final Integer BABY_AVERAGE_SCORE = 10;

    private Constants() {
        //constructor for checkstyle
    }

}
