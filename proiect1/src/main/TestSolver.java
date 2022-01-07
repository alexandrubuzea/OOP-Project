package main;

import common.Constants;
import database.Database;
import entities.Change;
import input.InputData;
import output.OutputData;
import parser.MyFileParser;

import java.util.ArrayList;
import java.util.List;

public class TestSolver {

    public TestSolver() { }

    public void solveTest(int testNumber) {
        String inputFileName = Constants.INPUT_PATH + testNumber + Constants.FILE_EXTENSION;

        MyFileParser parser = new MyFileParser(inputFileName);

        InputData input = parser.parseJSONFile();

        Database.setInput(input);
        Database database = Database.getDatabase();

        int numberOfYears = input.getNumberOfYears();

        // TODO : do we have to use List<Change> ?
        List<Change> changes = new ArrayList<>(input.getChanges().stream().map(Change::new).toList());

        // TODO: logica temei

        // clear the input and the database for the next test
        Database.setInput(null);
        Database.setDatabase(null);
    }
}