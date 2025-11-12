package com.app;

import java.util.*;

import com.app.exception.CensusAnalyserException;

public class MainApplication {
	public static void main(String[] ardgs) throws CensusAnalyserException {
		String csvFilePath = "src/test/resources/IndiaStateCode.csv";

        try {
            StateCodeAnalyser analyser = new StateCodeAnalyser();
            List<CSVStates> stateList = analyser.loadStateCodeData(csvFilePath);

            System.out.println("Number of records = " + stateList.size());

  
            for (CSVStates state : stateList) {
                System.out.println(state);
            }

        } catch (CensusAnalyserException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
