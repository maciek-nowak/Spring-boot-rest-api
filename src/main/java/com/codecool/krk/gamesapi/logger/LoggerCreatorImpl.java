package com.codecool.krk.gamesapi.logger;

import com.codecool.krk.gamesapi.studio.StudioServiceImplArchive;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.stereotype.Component;

@Component
public class LoggerCreatorImpl implements LoggerCreator{

    private static final Logger logger = LogManager.getLogger(StudioServiceImplArchive.class);
    private Marker myMarker = MarkerManager.getMarker("MYLOG");

    public void logError(String message) {

        logger.error(myMarker, message);
    }

    public void logInfo(String message) {

        logger.info(myMarker, message);
    }
}
