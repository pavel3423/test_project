package by.application.test_project.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadUtil {

    private final static Logger log = LoggerFactory.getLogger(ThreadUtil.class);

    private ThreadUtil() {
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("ThreadUtil", e);
        }
    }
}
