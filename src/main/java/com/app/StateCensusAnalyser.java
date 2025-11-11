package com.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exception.CensusAnalyserException;

public class StateCensusAnalyser {

    private List<CSVStateCensus> censusList = new ArrayList<>();

    public Iterator<CSVStateCensus> loadCensusData(String csvFilePath) throws CensusAnalyserException {
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
        } catch (IOException e) {
            throw new CensusAnalyserException("File not found or cannot be opened",
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        } catch (Exception e) {
            throw new CensusAnalyserException("Unable to parse CSV file",
                    CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
        return censusList.iterator();
    }
}
