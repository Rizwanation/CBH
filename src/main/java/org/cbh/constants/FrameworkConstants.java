package org.cbh.constants;

public final class FrameworkConstants {
    private FrameworkConstants(){

    }

    private static final String USERDIR = System.getProperty("user.dir");
    private static final String CONFIGFILEPATH = getUserDir() + "//Configs//config.properties";

    public static String getUserDir() {
        return USERDIR;
    }
    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }
}
