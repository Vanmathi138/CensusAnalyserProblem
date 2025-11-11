package com.app;

import java.util.*;

public class MainApplication {
	public static void main(String[] ardgs) {
		String csvFilePath = "IndiaStateCensusData.csv";
        StateCensusAnalyser analyser = new StateCensusAnalyser();

       
        Iterator<CSVStateCensus> iterator = analyser.loadCensusData(csvFilePath);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }	}
}
