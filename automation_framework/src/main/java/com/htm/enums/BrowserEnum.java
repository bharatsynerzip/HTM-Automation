package com.htm.enums;

/**
 * This is a browser enum to hold values for supported browsers
 */
public enum BrowserEnum {
    FIREFOX("firefox"), CHROME("chrome"), INTERNETEXPLORER("ie"), PHANTOMJS("headless");
    private String value;

    private BrowserEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
