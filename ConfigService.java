import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * The ConfigService class is responsible for reading configuration properties from a file.
 * It uses a Logger object to log messages related to the configuration file.
 */
public class ConfigService {

    /**
     * The logger used for logging messages related to the configuration file.
     */
    private Logger logger;

    /**
     * The logger used for logging messages related to the configuration file.
     */
    private String fileName;

    /**
     * The constructor initializes the ConfigService object with a Logger and the name of the configuration file.
     *
     * @param logger - A Logger object used for logging messages related to the configuration file.
     * @param fileName - A String representing the name of the configuration file.
     */
    public ConfigService(Logger logger, String fileName) {
        this.logger = logger;
        this.fileName = fileName;
    }

    /**
     * The readConfig method reads configuration properties from a file and returns them as a Properties object.
     *
     * @return Properties - A Properties object containing the configuration properties read from the file.
     */
    public Properties readConfig() {
        Properties configProperties = new Properties();
        Scanner scanner = new Scanner(System.in);
        logger.info(this.fileName.toString());

        try (FileInputStream fis = new FileInputStream(this.fileName)) {
            configProperties.load(fis);
        } catch (FileNotFoundException ex) {
            logger.severe(String.valueOf(ex));
            System.exit(1);
        } catch (IOException ex) {
            logger.severe(String.valueOf(ex));
            System.exit(1);
        }

        return configProperties;
    }
}
