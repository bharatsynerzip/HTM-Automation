package com.htm.web.service.impls;

import static com.htm.utils.Constants.CHROME_HEADLESS_MODE;
import static com.htm.utils.Constants.LINUX_CHROME_DRIVERPATH;
import static com.htm.utils.Constants.MAC_CHROME_DRIVERPATH;
import static com.htm.utils.Constants.OS_NAME;
import static com.htm.utils.Constants.WEBDRIVER_CHROME_DRIVER;
import static com.htm.utils.Constants.WINDOWS_CHROME_DRIVERPATH;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.htm.enums.OSEnum;
import com.htm.utils.ConfigurationUtil;

/**
 * This is a implementation for chrome browser with headless browser
 */
public class ChromeBrowserImpl extends BaseBrowserImpl {
    Logger log = Logger.getLogger(ChromeBrowserImpl.class);

    public WebDriver getDriver() {
        String os = System.getProperty(OS_NAME).toLowerCase();
        log.info("Operating system: " + os);
        Properties config = ConfigurationUtil.getConfig();
        WebDriver driver = null;
        ChromeOptions chromeOptions = new ChromeOptions();
        log.info("Chrome Running in HeadLess Mode " + config.getProperty(CHROME_HEADLESS_MODE));
        if (config.getProperty(CHROME_HEADLESS_MODE).contains("true")) {
            chromeOptions.addArguments("--headless");
        }
        if (os.contains(OSEnum.WINDOWS.getValue())) {
            System.setProperty(WEBDRIVER_CHROME_DRIVER, config.getProperty(WINDOWS_CHROME_DRIVERPATH));
            driver = new ChromeDriver(chromeOptions);
        } else if (os.contains(OSEnum.LINUX.getValue())) {
            System.setProperty(WEBDRIVER_CHROME_DRIVER, config.getProperty(LINUX_CHROME_DRIVERPATH));
            driver = new ChromeDriver(chromeOptions);
        } else if (os.contains(OSEnum.MAC.getValue())) {
            System.setProperty(WEBDRIVER_CHROME_DRIVER, config.getProperty(MAC_CHROME_DRIVERPATH));
            driver = new ChromeDriver(chromeOptions);
        }
        postConfigure(driver);
        log.info("Execution started on url: " + driver.getCurrentUrl());
        return driver;
    }
}
