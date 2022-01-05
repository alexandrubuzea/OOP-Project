package main;

import common.Constants;
import input.InputData;
import parser.MyFileParser;

public class TestSolver {

    public TestSolver() {}

    public void solveTest(int testNumber) {
        String inputFileName = Constants.INPUT_PATH + testNumber + Constants.FILE_EXTENSION;

        MyFileParser parser = new MyFileParser(inputFileName);

        InputData input = parser.parseJSONFile();


    }
}