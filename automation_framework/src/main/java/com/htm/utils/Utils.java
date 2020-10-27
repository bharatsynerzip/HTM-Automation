package com.htm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * This class contains a common method which we can use in entire project
 * 
 * @author Bharat Puri
 *
 */
public class Utils {

	/**
	 * Wrapper method for Thread.sleep()
	 * 
	 * @param timeInSeconds
	 */
	public static void waitInSeconds(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gives File name with current TimeStamp
	 *
	 * @return filename string
	 */
	public static String getDynamicName(String startName) {
		return (startName + "-" + (new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
				.format(new Date())));
	}

	/**
	 * Generate the random 10 digit number
	 * 
	 * @return
	 */
	public static String getDynamicNumber() {
		Long number;
		number = (long)(Math.random()*100000 + 9920000000L);
		String numberAsString = number.toString();
	    return numberAsString;

	}
	
	@SuppressWarnings("unused")
	public static String generateRandomString() {
		String generatedString=null;
    int length = 6;
    boolean useLetters = true;
    boolean useNumbers = false;
    return generatedString = RandomStringUtils.random(length, useLetters, useNumbers).toLowerCase();
	}
}
