package com.codecool.krk.gamesapi.logger;

public interface LoggerCreator {

    void logError(String message);
    void logErrorEmail(Exception exception);
    void logInfo(String message);
    void logErrorEmailString(String message);
}
