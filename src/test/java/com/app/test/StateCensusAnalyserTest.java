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
	    public void givenStateCensusCSVFile_WhenHeaderIncorrect_ShouldThrowCustomException() {
	        StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

	        CensusAnalyserException exception = Assertions.assertThrows(
	                CensusAnalyserException.class,
	                () -> censusAnalyser.loadCensusData("src/test/resources/IndiaStateCensusDataWrongHeader.csv")
	        );

	        Assertions.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_HEADER, exception.type);
	    }

}
