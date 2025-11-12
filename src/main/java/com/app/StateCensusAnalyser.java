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

	public int loadCensusData(String csvFilePath) throws CensusAnalyserException {
	    try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
	        String headerLine = reader.readLine();
	        if (headerLine == null) {
	            throw new CensusAnalyserException("Empty file", CensusAnalyserException.ExceptionType.INCORRECT_HEADER);
	        }

	        String[] headers = headerLine.split(",");
	        if (!headers[0].equals("State") || !headers[1].equals("Population")
	                || !headers[2].equals("AreaInSqKm") || !headers[3].equals("DensityPerSqKm")) {
	            throw new CensusAnalyserException("Incorrect header",
	                    CensusAnalyserException.ExceptionType.INCORRECT_HEADER);
	        }
	        
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] data = line.split(",");
	            CSVStateCensus census = new CSVStateCensus(
	                    data[0].trim(),
	                    Integer.parseInt(data[1].trim()),
	                    Integer.parseInt(data[2].trim()),
	                    Integer.parseInt(data[3].trim())
	            );
	            censusList.add(census);
	        }

	        return censusList.size();
	    } catch (IOException e) {
	        throw new CensusAnalyserException("File not found", CensusAnalyserException.ExceptionType.INCORRECT_HEADER);
	    } catch (NumberFormatException e) {
	        throw new CensusAnalyserException("Invalid number format", CensusAnalyserException.ExceptionType.INCORRECT_TYPE);
	    }
	}
	
	}

