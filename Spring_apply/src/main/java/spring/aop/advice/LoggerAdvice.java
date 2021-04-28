package spring.aop.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author MaLi
 */
public class LoggerAdvice {
    public void logger() {
        Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);
        logger.info("LoggerAdvice logger...");
    }
}
