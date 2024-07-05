package com.TimeSheet.utils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logs {
	// Initialize Log4j logs
	public static Logger Log;
	public static void initLogs(String className) {
		Log = Logger.getLogger(className);
		PropertyConfigurator.configure("log4j.properties");
	}
	public static void startTestCase(String sTestCaseName) {
		Log.info("*******"+sTestCaseName+" TEST Execution START*******");
	 
		
	}
	// This is to print log for the ending of the test case
	public static void endTestCase(String testcase) {
		Log.info("*******"+testcase+" TEST END*********");
	}
	// Need to create these methods, so that they can be called
	public static void info(String message) {
		Log.info(message);
	}
	public static void warn(String message) {
		Log.warn(message);
	}
	public static void error(String message,String e) {
		Log.error(message+""+e);
	}
	public static void fatal(String message) {
		Log.fatal(message);
	}
	public static void debug(String message) {
		Log.debug(message);
	}
}
