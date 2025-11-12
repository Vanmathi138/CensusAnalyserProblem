package com.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.app.exception.CensusAnalyserException;

public class StateCodeAnalyser {

    public List<CSVStates> loadStateCodeData(String csvFilePath) throws CensusAnalyserException {
        List<CSVStates> stateList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line = reader.readLine(); 
            if (line == null || line.isEmpty()) {
                throw new CensusAnalyserException("Empty file", CensusAnalyserException.ExceptionType.INCORRECT_HEADER);
            }

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 4) {
                    throw new CensusAnalyserException("Incorrect delimiter or missing data",
                            CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER);
                }

                String srNo = data[0].trim();
                String stateName = data[1].trim();
                String tin = data[2].trim();
                String stateCode = data[3].trim();

                CSVStates state = new CSVStates(srNo, stateName, tin, stateCode);
                stateList.add(state);
            }

        } catch (IOException e) {
            throw new CensusAnalyserException("File not found", CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        } catch (NumberFormatException e) {
            throw new CensusAnalyserException("Invalid number format", CensusAnalyserException.ExceptionType.INVALID_TYPE);
        }

        return stateList;
    }
}
