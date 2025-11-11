package com.app.test;

import com.app.StateCensusAnalyser;
import com.app.CSVStateCensus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class StateCensusAnalyserTest {

    private static final String CENSUS_CSV_FILE_PATH = "IndiaStateCensusData.csv";

    @Test
    public void givenStateCensusCSVFile_WhenRead_ShouldReturnCorrectNumberOfRecords() {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        Iterator<CSVStateCensus> iterator = analyser.loadCensusData(CENSUS_CSV_FILE_PATH);

        int actualRecordCount = 0;
        while (iterator.hasNext()) {
            iterator.next();
            actualRecordCount++;
        }

        int expectedRecordCount = 4; 
        Assertions.assertEquals(expectedRecordCount, actualRecordCount,
                "Record count does not match!");
    }
}
