package com.jalbersh.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {

    private static final Logger logger = LoggerFactory.getLogger(SampleApplication.class);

    public static void main(String[] args) {
        printArguments(args);
        SpringApplication.run(SampleApplication.class, args);
    }

    /**
     * Method to print arguments
     *
     * @param args
     */
    public static void printArguments(String[] args) {
        logger.info("SampleApplication startup - printing all arguments");
        for (String arg : args) {
            logger.info(arg);
        }
    }
}
