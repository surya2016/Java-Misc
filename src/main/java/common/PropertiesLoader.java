package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

public class PropertiesLoader {
	
	
	
	public static Properties getProperty(String config) throws IOException
	{
		FileInputStream file;
		Properties prop = new Properties();
		
		if(config.equalsIgnoreCase("mainConfig"))
		{
			file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
			prop.load(file);
		}
		
		return prop;
	}
	
	
	public static Properties initLoad(String env) {
		FileInputStream file;
		Properties prop = new Properties();
		try {
			// Load configurations based on environment
			file = new FileInputStream("./resources/config." + env + ".properties");
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
			SmplLogger.LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		return prop;
	}

}
