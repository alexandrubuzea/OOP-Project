package writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import output.OutputData;

import java.io.File;

public class MyFileWriter {
    private final String filename;

    /**
     * A constructor that creates a MyFileWriter instance
     * @param filename the file used for writing output
     */
    public MyFileWriter(final String filename) {
        this.filename = filename;
    }

    /**
     * A method used to write the input using jackson package.
     * @param output the output data that needs to be written in the file with the given name.
     */
    public void writeJSONFile(final OutputData output) {
        File file = new File(filename);

        // create a writer
        ObjectWriter myWriter = new ObjectMapper()
                .writer()
                .withDefaultPrettyPrinter();

        try {
            myWriter.writeValue(file, output);
        } catch (Exception e) {
            System.err.println("Something wrong when writing");
            // System.exit(-1);
        }
    }
}
