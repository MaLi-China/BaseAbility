package watcher;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author MaLi
 */
public class LogFile {


    @Test
    public void testLogger1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Logger logger = Logger.getLogger(LogFile.class);
        logger.error("hello logger");
        logger.warn("logger warn");
        logger.info("logger info...");
    }

    @Test
    public void testLogger2() {

        org.slf4j.Logger logger = LoggerFactory.getLogger(LogFile.class);
        logger.error("hello logger");
        logger.warn("logger warn");
        logger.info("logger info...");

    }
}