package writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import output.OutputData;

import java.io.File;

public class MyFileWriter {
    private final String filename;

    public String getFilename() {
        return filename;
    }

    public MyFileWriter(String filename) {
        this.filename = filename;
    }

    public void writeJSONFile(OutputData output) {
        File file = new File(filename);

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(file, output);
        } catch (Exception e) {
            System.err.println("Something wrong when writing");
            // System.exit(1);
        }
    }
}
