package com.app;

import java.util.*;

import com.app.exception.CensusAnalyserException;

public class MainApplication {
	public static void main(String[] ardgs) throws CensusAnalyserException {
		String csvFilePath = "IndiaStateCensusData.csv";
        StateCensusAnalyser analyser = new StateCensusAnalyser();

       
        Iterator<CSVStateCensus> iterator = analyser.loadCensusData(csvFilePath);

        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }	}
}
