package com.htm.enums;

/**
 * This is a OS enum to hold values for supported operating systems
 */
public enum OSEnum {
    WINDOWS("windows"), MAC("mac"), LINUX("linux");
    private String value;

    private OSEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
