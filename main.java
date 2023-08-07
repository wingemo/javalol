import java.util.Properties;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * The Main class provides functionality for initializing a logger,
 * retrieving properties from a config file, and printing those properties
 * to the console.
 *
 * @author [Philip Wingemo]
 *
 */
public class Main {

    /**
     * The path to the configuration file.
     */
    public static String CONFIG_FILE = "src/app.config";

    /**
     * The name property key.
     */
    public static String PROPERTY_NANE = "app.name";

    /**
     * The version property key.
     */
    public static String PROPERTY_VERSION = "app.version";

    /**
     * This is the entry point for this application which initializes
     * and uses various utility classes to perform operations such as
     * retrieving configurations and printing them out to console using
     * initialized loggers.
     *
     *@param args command line arguments passed to this application
     */
    public static void main(String[] args) {
        Logger logger = initializeLogger();
        Properties prop = retrieveProperties(logger);
        HashMap<String, User> hashmapUser;
        printProperties(prop, logger);
    }

    /**
     * This method initializes a logger using a LoggingService object.
     *
     * @return A Logger object that can be used for logging messages.
     */
    public static Logger initializeLogger() {
        LogginService logginService  = new LogginService();
        Logger logger = LogginService.initialize();
        return logger;
    }

    /**
     * This method retrieves properties from a config file using a ConfigService object.
     *
     * @param logger A Logger object used for logging messages
     * @return A Properties object containing application properties
     */
    public static Properties retrieveProperties(Logger logger) {
        ConfigService configService  = new ConfigService(logger, CONFIG_FILE);
        return configService.readConfig();
    }

    /**
     * This method prints out two properties retrieved from a Properties object:
     * app.name and app.version.
     *
     * @param prop A Properties object containing application properties
     * @param logger A Logger object used for logging messages
     */
    public static void printProperties(Properties prop, Logger logger) {
        logger.info(prop.getProperty(PROPERTY_NANE));
        logger.info(prop.getProperty(PROPERTY_VERSION));
    }

}
