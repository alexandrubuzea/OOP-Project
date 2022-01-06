package database;

import entities.Child;
import input.InputData;

import java.util.Map;

public class Database {
    private static Database database = null;
    private static InputData input = null;

    Map<Integer, Child> children;

    public static void setInput(InputData input) {
        Database.input = input;
    }

    private Database(InputData input) {

    }

    public static Database getDatabase() {
        if (database == null)
            database = new Database(Database.input);
        return database;
    }


}
