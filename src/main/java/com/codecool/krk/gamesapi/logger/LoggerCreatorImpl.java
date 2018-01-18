package com.codecool.krk.gamesapi.logger;

import com.codecool.krk.gamesapi.studio.StudioServiceImplArchive;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Component
public class LoggerCreatorImpl implements LoggerCreator{

    private static final Logger logger = LogManager.getLogger(StudioServiceImplArchive.class);
    private Marker myMarker = MarkerManager.getMarker("MYLOG");
    private Marker smtpMarker = MarkerManager.getMarker("EMAIL");

    public void logError(String message) {

        logger.error(myMarker, message);
    }

    @Override
    public void logErrorEmail(Exception exception) {
        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();
        logger.error(smtpMarker, exceptionAsString);
    }

    public void logErrorEmailString(String message) {

        logger.error(smtpMarker, message);
    }

    public void logInfo(String message) {

        logger.info(myMarker, message);
    }
}
