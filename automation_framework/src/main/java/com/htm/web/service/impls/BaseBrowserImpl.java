package com.htm.web.service.impls;
import static com.htm.utils.Constants.TESTSITE_BASE_URL;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.htm.utils.ConfigurationUtil;
import com.htm.web.service.Browser;

/**
 * This is a base implementation for browser interface
 * contains common operation to be shared across browsers
 */
public abstract class BaseBrowserImpl implements Browser {
	Logger log = Logger.getLogger(BaseBrowserImpl.class);
    /**
     * This operation post configures driver for browser
     * after being instantiated
     * @param driver
     */
    protected void postConfigure(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
      
        Properties config = ConfigurationUtil.getConfig();
        log.info("appURL value: " + (config.getProperty(TESTSITE_BASE_URL) != null));
        if (config.getProperty(TESTSITE_BASE_URL) != null) {
        	driver.get(config.getProperty(TESTSITE_BASE_URL));
        } else {
        	driver.get(config.getProperty(TESTSITE_BASE_URL));
        }
    }
}
