package com.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StateCensusAnalyser {

    private List<CSVStateCensus> censusList = new ArrayList<>();

    public Iterator<CSVStateCensus> loadCensusData(String csvFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean headerSkipped = false;
            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {  
                    headerSkipped = true;
                    continue;
                }
                
                String[] data = line.split(",");
                String state = data[0].trim().replaceAll("\"", "");
                int population = Integer.parseInt(data[1].trim().replaceAll("\"", ""));
                int area = Integer.parseInt(data[2].trim().replaceAll("\"", ""));
                int density = Integer.parseInt(data[3].trim().replaceAll("\"", ""));


                CSVStateCensus census = new CSVStateCensus(state, population, area, density);
                censusList.add(census);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return censusList.iterator();
    }
}
