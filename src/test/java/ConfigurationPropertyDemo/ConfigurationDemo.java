package ConfigurationPropertyDemo;

import Utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationDemo {

    @Test
    void test(){
        System.out.println(ConfigurationReader.getProperty("url"));
        System.out.println(ConfigurationReader.getProperty("database.password"));
        System.out.println(ConfigurationReader.getProperty("browserType"));
    }


}
