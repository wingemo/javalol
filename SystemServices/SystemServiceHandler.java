package SystemServices;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * The Main class provides functionality for initializing a logger,
 * retrieving properties from a config file, and printing those properties
 * to the console.
 *
 * @author [Philip Wingemo]
 *
 */
public class SystemServiceHandler {

    /**
     * The path to the configuration file.
     */
    public static String ENV_FILE = "src/.env";

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
        readEnv();
        Logger logger = initializeLogger();
        Properties prop = retrieveProperties(logger);
        printProperties(prop, logger);
    }

    /**
     * This method reads environment variables from a file using an SystemServices.EnvService object.
     *
     * @throws RuntimeException if there is an error reading from the file
     */
    public static void readEnv(){
        EnvService envService = new EnvService(ENV_FILE);
        try {
            envService.readEnv();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
     * This method retrieves properties from a config file using a SystemServices.ConfigService object.
     *
     * @param logger A Logger object used for logging messages
     * @return A Properties object containing application properties
     */
    public static Properties retrieveProperties(Logger logger) {
        ConfigService configService  = new ConfigService(logger, System.getProperty("CONFIG_FILE"));
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