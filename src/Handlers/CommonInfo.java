package Handlers;

public class CommonInfo {

    public static String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    public static String pathsPath = rootPath + "paths.properties";

}
