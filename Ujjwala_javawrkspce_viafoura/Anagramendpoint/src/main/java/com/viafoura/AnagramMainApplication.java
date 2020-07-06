package com.viafoura;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ujju
 *
 */
@SpringBootApplication
public class AnagramMainApplication {

	/**
	 * Logger 
	 */
	static Logger logger = Logger.getLogger(AnagramMainApplication.class);
	/**
	 * @param args
	 */
	public static void main(String args[])
	{
		logger.info("Application started");
		SpringApplication.run(AnagramMainApplication.class, args);
	}

}
