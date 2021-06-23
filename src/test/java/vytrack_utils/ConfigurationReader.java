package vytrack_utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {
        //2. Load the file into FileInputStream
        try {
            FileInputStream file = new FileInputStream("configuration.properties");

            //3. Load the properties object with the file (configuration.properties)
            properties.load(file);

            //close the file
            file.close();

        } catch (IOException e) {

            System.out.println("File not found in Configuration Properties");
        }
    }

    //use the above to create a reusable static method
    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }

}
