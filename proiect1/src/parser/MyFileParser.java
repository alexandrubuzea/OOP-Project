package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import input.InputData;

import java.io.File;

public class MyFileParser {

    private final String inputFilePath;

    public String getInputFilePath() {
        return inputFilePath;
    }

    public MyFileParser(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public MyFileParser() {
        this(null);
    }

    public InputData parseJSONFile() {
        File file = new File(inputFilePath);

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
