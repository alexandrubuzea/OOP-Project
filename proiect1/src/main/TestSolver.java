package main;

import common.Constants;
import database.Database;
import entities.Change;
import input.InputData;
import output.OutputData;
import output.RoundData;
import parser.MyFileParser;
import roundStatus.Round;
import writer.MyFileWriter;

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

        List<Change> changes = new ArrayList<>(input.getChanges().stream().map(Change::new).toList());

        // TODO: prepare output
        OutputData output = new OutputData();

        // TODO: runda 0
        Round round = new Round();
        round.calculateAverageScores();
        round.calculateAssignedBudgets();
        round.assignGifts();

        output.getRounds().add(new RoundData(round));
        round = null;
        // TODO: rundele 1-noOfYears

        for (int i = 1; i <= numberOfYears; ++i) {
            database.applyChange(changes.get(i - 1));
            round = new Round();

            // perform changes on round entity
            round.calculateAverageScores();
            round.calculateAssignedBudgets();
            round.assignGifts();

            output.getRounds().add(new RoundData(round));
        }

        String outputFileName = Constants.OUTPUT_PATH + testNumber + Constants.FILE_EXTENSION;

        MyFileWriter writer = new MyFileWriter(outputFileName);
        writer.writeJSONFile(output);

        // clear the input and the database for the next test
        Database.setInput(null);
        Database.setDatabase(null);
    }
}