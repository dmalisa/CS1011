/*
 * Course: CS1011-051
 * Fall 2020-2021
 * File header contains class BuildingCostEstimator
 * Name: Malisa 2
 * Created 14/10/2020
 */
package week6;

/**
 * Course CS1011-051
 * Fall 2020-2021
 * BuildingCostEstimator purpose: class that estimates the cost of building a house
 *
 * @author Malisa 2
 * @version created on 14/10/2020 at 19:54
 */

public class BuildingCostEstimator {

    private int numFullBaths;
    private int numHalfBaths;
    private int numBedrooms;
    private int numWindows;
    private double numGarages;
    private int squareFeet;

    //declaration of constant numbers
    final int COST_FULL_BATHS = 20000;
    final int COST_HALF_BATHS = 7000;
    final int COST_BEDROOMS = 3000;
    final int COST_WINDOWS = 1000;
    final int COST_SQUARE_FEET = 135;
    final double COST_GARAGES = 8000;

 //  setter for building cost estimation
    public void setNumFullBaths(int numFullBaths) {
        this.numFullBaths = numFullBaths;
    }

    public void setNumHalfBaths(int numHalfBaths) {
        this.numHalfBaths = numHalfBaths;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public void setNumWindows(int numWindows) {
        this.numWindows = numWindows;
    }

    public void setNumGarages(double numGarages) {
        this.numGarages = numGarages;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

// getters for building cost estimation
    public int getNumBedrooms() {
        return numBedrooms;
    }

    public int getNumFullBaths() {
        return numFullBaths;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public int getNumWindows() {
        return numWindows;
    }

    public int getNumHalfBaths() {
        return numHalfBaths;
    }

    public double getNumGarages() {
        return numGarages;
    }

    /**
     * calculating the cost to build a house
     * @return cost of building a house
     **/
    public double costToBuild() {
        double costToBuild;
        costToBuild = (squareFeet * COST_SQUARE_FEET) + (numFullBaths * COST_FULL_BATHS)+
               (numHalfBaths * COST_HALF_BATHS) + (numBedrooms * COST_BEDROOMS)+
               (numWindows * COST_WINDOWS) + (numGarages * COST_GARAGES);
        return costToBuild;
    }

    /**
    constructor
     */
    public void buildingCostEstimator(){
    }


}

    //code for unit testing of class BuildingCostEstimator
    //or delete this main method



