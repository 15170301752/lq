package Btjf_API.CAPI.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by wl on 2016/6/28.
 */
public class Log {
    private Class clazz;
    private  static Logger logger;
    File config = new File("src/main/resources/log4j2.xml");
    public Log(Class clazz) {
        try{
            ConfigurationSource source = new ConfigurationSource(new FileInputStream(config),config);
            Configurator.initialize(null,source);
            this.clazz = clazz;
            logger = LogManager.getLogger();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void trace(String message){
        logger.trace(clazz.getSimpleName()+":"+message);
    }
    public void debug(String message){
        logger.debug(clazz.getSimpleName()+":"+message);
    }
    public void info(String message){
        logger.info(clazz.getSimpleName()+":"+message);
    }
    public void error(String message){
        logger.error(clazz.getSimpleName()+":"+message);
    }

    public static void main(String[] args){
        Log log = new Log(Log.class);
        log.info("hehe");
        log.debug("heihei");
        log.error("haha");
        log.trace("haha");
    }
}
