package Btjf_API.CAPI.Test;


import Btjf_API.CAPI.Utils.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by wl on 2017/8/4.
 */
public class LogTest {

    private Logger logger;
    private Class clazz;
    public LogTest(Class clazz){
        File config = new File("src/main/resources/log4j2.xml");
        ConfigurationSource source = null;
        try {
            source = new ConfigurationSource(new FileInputStream(config),config);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Configurator.initialize(null,source);
        this.clazz = clazz;
        logger = LogManager.getLogger(this.clazz);
    }
    public void info(String s){
        logger.info(clazz.getSimpleName()+":"+s);
    }
    public void debug(String s){
        logger.debug(clazz.getSimpleName()+":"+s);
    }
    public void error(String s){
        logger.error(clazz.getSimpleName()+":"+s);
    }

//    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) throws Exception{
        LogTest logTest = new LogTest(LogTest.class);
        logTest.debug("-----debug-----");
        logTest.info("-----info-----");
        logTest.error("-----error----");
    }

}
