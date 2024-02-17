package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    static Properties configFile;
    static{
        String path = "./src/test/resources/Configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method will return the property value of the chosen string
     * @param key -> The key value you want to retrieve
     * @return a String type for the value of the key in the config file
     */
    public static String getProperty(String key){
        return configFile.getProperty(key);
    }





}
