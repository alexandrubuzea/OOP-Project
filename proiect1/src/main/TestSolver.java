package main;

import common.Constants;
import database.Database;
import input.InputData;
import output.OutputData;
import parser.MyFileParser;

public class TestSolver {

    public TestSolver() {}

    public void solveTest(int testNumber) {
        String inputFileName = Constants.INPUT_PATH + testNumber + Constants.FILE_EXTENSION;

        MyFileParser parser = new MyFileParser(inputFileName);

        InputData input = parser.parseJSONFile();

        Database.setInput(input);
        Database database = Database.getDatabase();


    }
}