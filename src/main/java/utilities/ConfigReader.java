package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties prop;
    public static Properties loadProperties()
    {
        try {
            prop = new Properties();
            prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/config.properties"));

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return prop;
    }
}
