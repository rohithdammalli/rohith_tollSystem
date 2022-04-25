package com.rohith.tollsytem.app.logger;

import org.slf4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 
 * LoggerUtil: Util class acting as a wrapper for
 * the slf4j logger implementation.
 *
 */
public class LoggerUtil {
private Logger logger = null;
	
	public LoggerUtil(Class clazz){
		logger = LoggerFactory.getLogger(clazz);
	}
	
	public void info(String msg){
		logger.info(msg);
	}
	
	public void info(String logFrmt, String msg){
		logger.info(logFrmt, msg);
	}
	
	public void info(String logFrmt, String msg1, String msg2){
		logger.info(logFrmt, msg1, msg2);
	}
	
	public void debug(String msg){
		logger.debug(msg);
	}
	
	public void debug(String logFrmt, String msg){
		logger.debug(logFrmt, msg);
	}
	
	public void error(String msg){
		logger.error(msg);
	}
	
	public void error(String logFrmt, String msg){
		logger.error(logFrmt, msg);
	}
	
	public void error(String logFrmt, Throwable ex){
		logger.error(logFrmt, ex);
	}
	
	public void error(String logFrmt, String msg, Throwable ex){
		logger.error(logFrmt, msg, ex);
	}
	
	public static String getDurationInSecs(long startTime){
		long endTime = System.currentTimeMillis();
		String duration = (endTime - startTime) / 1000.0 +"";
		return duration;
	}
	
	public void clearMDC(){
		MDC.clear();
	}
}
