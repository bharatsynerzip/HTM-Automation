package com.htm.utils;

import static com.htm.utils.Constants.CONFIG;
import static com.htm.utils.Constants.CONFIG_PROPERTIES;
import static com.htm.utils.Constants.DATA;
import static com.htm.utils.Constants.TEST_DATA_MOBILE_PROPERTIES;
import static com.htm.utils.Constants.TEST_DATA_WEB_PROPERTIES;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;
/**
 * This class contains utility methods to access configuration settings from
 * files
 */
public class ConfigurationUtil {
   // private static final String TEST_DATA_PROPERTIES = null;
	private static Properties config;
    private static Properties testDataProp;
  //  private static Properties loginPageProp;


    /**
     * This operation load file from a given directory
     *
     * @param dir      - provide directory path
     * @param fileName - provide name of the file to read
     * @return properties from give file
     */
    public static Properties loadConfig(String dir, String fileName) {
        Properties config = new Properties();
        FileInputStream ip = null;
        String path = dir + File.separator
                + fileName;
        File file = new File(path);
        if (!file.exists()) {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            URL resourceURL = loader.getResource(path);
            try {
                path = URLDecoder.decode(resourceURL.getPath(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
        try {
            ip = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }

    /**
     * Loads project configuration
     *
     * @return project configuration
     */
    public static Properties getConfig() {
        if (config == null) {
            config = loadConfig(CONFIG, CONFIG_PROPERTIES);
        }
        return config;
    }
    
    public static Object getValue(Object key) {
    	return config.get(key);
    }
    
    /**
     * Loads Promo Code File
     *
     * @return Promo Code File data
     */
    public static Properties getTestData() {
        if (testDataProp == null) {
        	testDataProp = loadConfig(DATA, TEST_DATA_WEB_PROPERTIES);
        }
        return testDataProp;
    }
    
    public static Properties getMobileTestData() {
        if (testDataProp == null) {
        	testDataProp = loadConfig(DATA, TEST_DATA_MOBILE_PROPERTIES);
        }
        return testDataProp;
    }
    
}
