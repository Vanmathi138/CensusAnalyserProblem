package com.app.test;

import com.app.StateCensusAnalyser;
import com.app.exception.CensusAnalyserException;
import com.app.CSVStateCensus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class StateCensusAnalyserTest {

	private static final String WRONG_DELIMITER_FILE_PATH = "src/test/resources/IndiaStateCensusDataWrongDelimiter.csv";

    @Test
    public void givenStateCensusCSVFile_WhenDelimiterIncorrect_ShouldThrowCustomException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        CensusAnalyserException thrown = Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadCensusData(WRONG_DELIMITER_FILE_PATH),
                "Expected CensusAnalyserException but did not get one"
        );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER,
                thrown.type,
                "Expected INCORRECT_DELIMITER exception"
        );
    }    
}
