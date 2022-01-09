package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import input.InputData;

import java.io.File;

/**
 * A class used to parse a JSON file with the given name.
 */
public class MyFileParser {

    /**
     * The name of the JSON file to parse
     */
    private final String inputFilePath;

    /**
     * A constructor for the parser entity
     * @param inputFilePath the name of the file to parse
     */
    public MyFileParser(final String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    /**
     * A default constructor for the parser entity
     */
    public MyFileParser() {
        this(null);
    }

    /**
     * A method used to parse the JSON file with the given name using jackson library
     * @return the parsed input
     */
    public InputData parseJSONFile() {
        File file = new File(inputFilePath);

        // create an ObjectMapper instance to read from the input file
        ObjectMapper mapper = new ObjectMapper();

        InputData input = null;

        try {
            input = mapper.readValue(file, InputData.class);
        } catch (Exception e) {
            System.err.println("Exception met while parsing");
            System.exit(-1);
        }

        return input;
    }
}
