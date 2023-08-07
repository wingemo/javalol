import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * A class that reads environment variables from a file and adds them to the system environment.
 */
public class EnvService {
    private String fileName;

    /**
     * Constructs a new EnvService object with the specified file name.
     *
     * @param fileName the name of the file containing environment variables
     */
    public EnvService(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads environment variables from the file and adds them to the system environment.
     *
     * @throws IOException if there is an error reading from the file
     */
    public void readEnv() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=");
            if (parts.length >= 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                System.setProperty(key, value);
            }
        }
        reader.close();
        
        if(!Boolean.valueOf(System.getProperty("Development"))){
            boolean success = (new File(this.fileName)).delete();
        }
    }

}
}
