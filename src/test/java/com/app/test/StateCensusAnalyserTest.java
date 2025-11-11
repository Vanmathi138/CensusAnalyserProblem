package com.app.test;

import com.app.StateCensusAnalyser;
import com.app.exception.CensusAnalyserException;
import com.app.CSVStateCensus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class StateCensusAnalyserTest {

	private static final String WRONG_FILE_TYPE_PATH = "IndiaStateCensusData.txt"; // ❌ not .csv

    @Test
    public void givenStateCensusCSVFile_WhenTypeIncorrect_ShouldThrowCustomException() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException thrown = Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadCensusData(WRONG_FILE_TYPE_PATH),
                "Expected CensusAnalyserException but did not get one"
        );

        Assertions.assertEquals(
                CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE,
                thrown.type,
                "Expected INVALID_FILE_TYPE exception"
        );
    }
}
