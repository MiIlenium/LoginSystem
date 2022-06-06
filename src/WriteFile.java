import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public void writeToFile(String userName, String password) throws IOException {
        BufferedWriter wr;
        //The name of the file in the FS
        final String outputFilePath = "userCredentials.txt";
        File file = new File(outputFilePath);

        //Writing userdata into the file, delimited by the colon
        wr = new BufferedWriter(new FileWriter(file, true));
        wr.write(userName + ":" + password);
        wr.newLine();
        wr.flush();
        wr.close();
    }
}
