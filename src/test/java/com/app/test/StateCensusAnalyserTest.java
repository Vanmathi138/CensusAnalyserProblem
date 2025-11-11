package com.app.test;

import com.app.StateCensusAnalyser;
import com.app.exception.CensusAnalyserException;
import com.app.CSVStateCensus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class StateCensusAnalyserTest {

	private static final String WRONG_CSV_FILE_PATH = "IndiaStateCensusDataa.csv";

    @Test
    public void givenStateCensusCSVFile_WhenIncorrectPath_ShouldThrowCustomException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException thrown = Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadCensusData(WRONG_CSV_FILE_PATH),
                "Expected CensusAnalyserException but didn't get one"
        );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,
                thrown.type
        );
    }
}
