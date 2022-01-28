package com.revature.logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
    // let's create an instance of the logger class
    static Logger log = LogManager.getLogger(Log4jDemo.class);
    public static void main(String[] args) {

            System.out.println("\n Hello world....... \n");
            log.info("this is an information message");
            log.error("this is an error message");
            log.warn("this is a warning message");
            log.fatal("this is a fatal message");
            System.out.println("\n completed.....");

    }
    }

