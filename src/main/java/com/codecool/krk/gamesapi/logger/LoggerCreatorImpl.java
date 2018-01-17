package com.codecool.krk.gamesapi.logger;

import com.codecool.krk.gamesapi.studio.StudioServiceImplArchive;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LoggerCreatorImpl implements LoggerCreator{

    private static final Logger logger = LogManager.getLogger(StudioServiceImplArchive.class);

    public void logError(String message) {

        logger.error(message);
    }

    public void logInfo(String message) {

        logger.info(message);
    }
}
