package com.test.regression.eDeals.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logg {

	private static Logger _logger;

	/**
	 * This method creates instance of the Logger class coming from log4j jar by
	 * implementing a singleton
	 * 
	 * @return _logger - new instance if no instance exist else an existing
	 *         instance if the method is invoked previously
	 */
	public static Logger createLogger() {
	    if (_logger == null) {
	        _logger = LogManager.getLogger(Logg.class);
	        return _logger;
	    } else
	        return _logger;
	}
}
