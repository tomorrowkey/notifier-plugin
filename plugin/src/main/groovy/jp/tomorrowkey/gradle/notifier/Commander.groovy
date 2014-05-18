package jp.tomorrowkey.gradle.notifier

import org.gradle.api.logging.Logger

public class Commander {

    private Logger logger;

    public Commander(Logger logger) {
        this.logger = logger;
    }

    public void execute(String... commands) {
        if(commands == null) {
            throw new IllegalArgumentException("commands must not be null");
        }

        logger.info("commands")
        commands.each() { command ->
            logger.info(" command=" + command)
        }
        commands.execute()
    }
}
