package main;

import checker.Checker;
import common.Constants;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) {
        // create one instance of test solver
        TestSolver solver = new TestSolver();

        // solve each test
        for (int i = 1; i <= Constants.TESTS_NUMBER; ++i) {
            solver.solveTest(i);
        }

        // calculate the score
        Checker.calculateScore();
    }
}
