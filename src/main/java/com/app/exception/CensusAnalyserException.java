package com.app.exception;

public class CensusAnalyserException extends Exception {

    public enum ExceptionType {
        FILE_NOT_FOUND,
        INVALID_FILE_TYPE,
        UNABLE_TO_PARSE,
        INCORRECT_DELIMITER,
        INCORRECT_HEADER,
        INCORRECT_TYPE,
        INVALID_TYPE
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
    
}
