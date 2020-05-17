package ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    public static void main(String[] args) {
        Properties appConfig = loadDefaultProperties();

        for (String s : appConfig.stringPropertyNames()) {
            System.out.println(String.format("%s : %s", s, appConfig.getProperty(s)));
        }
    }

    private static final String APPLICATION_NAME = "ConfigReader";
    private static final String MAIN_CONFIGURATION_FILE = "app.config";

    public static Properties loadDefaultProperties() {
        String fileName = getDefaultConfigurationFile().getAbsolutePath();
        return loadConfigValues(fileName);
    }

    /**
     * Generic property loading method.
     * @param fileName
     * @return Property bag with the properties inside it.
     */
    private static Properties loadConfigValues(String fileName) {
        Properties retProp = new Properties();

        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
        } catch (FileNotFoundException ex) {
            System.err.println("Could not open InputStream.  Exception: ");
            ex.printStackTrace();
        }

        try {
            retProp.load(is);
        } catch (IOException ex) {
            System.err.println("Could not load properties.  Exception: ");
            ex.printStackTrace();
        }

        return retProp;
    }
    
    /**
     * Get the location of the configuration file.
     */
    private static File getDefaultConfigurationFile() {
        File configurationFile = null;
        File location1 = new File(System.getProperty("user.dir"), MAIN_CONFIGURATION_FILE);
        File location2 = new File(Paths.get(System.getProperty("user.dir"), APPLICATION_NAME, MAIN_CONFIGURATION_FILE).toString());
        
        // Try loading the configuration file from the current directory.
        if(location1.isFile()) {
            configurationFile = location1;
        } else if(location2.isFile()) {
            configurationFile = location2;
        } else {
            System.err.println("Could not locate the configuration file under " + System.getProperty("user.dir") + " or the alternate path.");
        }

        return configurationFile;
    }
}