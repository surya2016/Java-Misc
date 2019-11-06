package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class SmplLogger {
	private static final LogManager logManager = LogManager.getLogManager();
	public static final Logger LOGGER = Logger.getLogger("smplLogger");
	static{
		try {
			logManager.readConfiguration(new FileInputStream("resources/logging.properties"));
		} catch (IOException exception) {
			LOGGER.log(Level.SEVERE, "Error in loading configuration",exception);
		}
	}
}
