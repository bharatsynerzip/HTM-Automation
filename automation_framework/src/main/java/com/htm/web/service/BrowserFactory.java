package com.htm.web.service;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.htm.enums.BrowserEnum;
import com.htm.web.service.impls.ChromeBrowserImpl;



/**
 * Factory framework allows us to put in place a single entry point while
 * handling browser operations. Depending on the browser,
 * instance will be returned to perform operations on the browser
 */
public class BrowserFactory {
    private static Map<String, WebDriver> factory;

    static ChromeBrowserImpl chrome = new ChromeBrowserImpl();
   // static FirefoxBrowserImpl firefox = new FirefoxBrowserImpl();
    static {
        factory = new HashMap<String, WebDriver>();
        factory.put(BrowserEnum.CHROME.getValue(),chrome.getDriver());
//        factory.put(BrowserEnum.FIREFOX.getValue(),firefox.getDriver());
                
    }

    /**
     * This operation creates browser instances
     * @return
     */
    public static WebDriver createBrowser(String browserType) {

        return factory.get(browserType);
    }
}
