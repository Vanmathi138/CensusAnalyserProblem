package com.app;

public class CSVStateCensus {
    private String state;
    private int population;
    private int areaInSqKm;
    private int densityPerSqKm;

    
    public CSVStateCensus(String state, int population, int areaInSqKm, int densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }

    public String getState() { return state; }
    public int getPopulation() { return population; }
    public int getAreaInSqKm() { return areaInSqKm; }
    public int getDensityPerSqKm() { return densityPerSqKm; }

    @Override
    public String toString() {
        return "State: " + state + ", Population: " + population +
               ", Area: " + areaInSqKm + ", Density: " + densityPerSqKm;
    }
}
