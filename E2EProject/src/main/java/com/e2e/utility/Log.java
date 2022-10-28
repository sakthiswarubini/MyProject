package com.e2e.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
 
 // Initialize Log4j logs
 public static Logger demoLogger = LogManager.getLogger(Log.class.getName());

 public static void startTestCase(String sTestCaseName){    
	 demoLogger.info("====================================="+sTestCaseName+" TEST START=========================================");
   }
 
 public static void endTestCase(String sTestCaseName){
   
	 demoLogger.info("====================================="+sTestCaseName+" TEST END=========================================");
   }
 
 // Need to create below methods, so that they can be called  

  public static void info(String message) {

	  demoLogger.info(message);

   }

  public static void warn(String message) {

	  demoLogger.warn(message);

  }

  public static void error(String message) {

	  demoLogger.error(message);

  }

  public static void fatal(String message) {

	  demoLogger.fatal(message);

  }

  public static void debug(String message) {

	  demoLogger.debug(message);

  }
 
}