package SystemServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public  class LogginService {

    private static final Logger LOGGER = Logger.getLogger("SystemLogger");
    private static FileHandler fileHandler;

    public static Logger initialize(){
        try {
            PrintWriter writer = new PrintWriter("log.txt");
            writer.print("");
            writer.close();
            fileHandler = new FileHandler("log.txt", true);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception occurred while initializing file handler", e);
        }
        LOGGER.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        LOGGER.setUseParentHandlers(false);
        return LOGGER;
    }

    public static void log(String message) {
        LOGGER.log(Level.INFO, message);
    }

}