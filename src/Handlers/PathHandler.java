package Handlers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PathHandler {

    private static Properties pathProperties = new Properties();

    public static String getPath(String name) {
        if (pathProperties.size() == 0) {
            try {
                pathProperties.load(new FileInputStream(CommonInfo.pathsPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pathProperties.getProperty(name);
    }

}