package main;

import common.Constants;
import database.Database;
import entities.Change;
import input.InputData;
import output.OutputData;
import output.RoundData;
import parser.MyFileParser;
import roundstatus.Round;
import writer.MyFileWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * A class used to solve one test at one time.
 */
public class TestSolver {

    /**
     * A default constructor for checkstyle
     */
    public TestSolver() { }

    /**
     * A method used to solve one test.
     * @param testNumber the number of the test to solve.
     */
    public void solveTest(final int testNumber) {
        // create file input name
        String inputFileName = Constants.INPUT_PATH + testNumber + Constants.FILE_EXTENSION;

        // create a MyFileParser instance to parse the input
        MyFileParser parser = new MyFileParser(inputFileName);

        // parse the input
        InputData input = parser.parseJSONFile();

        // put the input data in the database
        Database.setInput(input);

        // create a database instance (the getDatabase() method is used for the first time)
        Database database = Database.getDatabase();

        // the number of rounds (one round per year)
        int numberOfYears = input.getNumberOfYears();

        // the changes foar each round starting from 1 to numberOfYears
        List<Change> changes = new ArrayList<>(input.getChanges()
                .stream().map(Change::new).toList());

        // creating an entity for the output data
        OutputData output = new OutputData();

        // round 0
        database.removeAdults();
        Round round = new Round();
        round.calculateAverageScores();
        round.calculateAssignedBudgets();
        round.assignGifts();

        // add the results from round 0 to the output.
        output.getRounds().add(new RoundData(round));

        // rounds 1 to numberOfYears
        for (int i = 1; i <= numberOfYears; ++i) {
            // apply changes
            database.applyChange(changes.get(i - 1));

            // creating a new round entity
            round = new Round();

            // perform changes on round entity
            round.calculateAverageScores();
            round.calculateAssignedBudgets();
            round.assignGifts();

            // add the results from round i to the output.
            output.getRounds().add(new RoundData(round));
        }

        // create file output name
        String outputFileName = Constants.OUTPUT_PATH + testNumber + Constants.FILE_EXTENSION;

        // create a MyFileWriter instance
        MyFileWriter writer = new MyFileWriter(outputFileName);

        // write the results into the corresponding JSON file
        writer.writeJSONFile(output);

        // clear the input and the database for the next test
        Database.setInput(null);
        Database.setDatabase(null);
    }
}
