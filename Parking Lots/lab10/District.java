/*
 * Course: CS1011-051
 * Fall 2020-2021
 * File header contains class District
 * Name: Malisa denise
 * Created 11/11/2020
 */
package week10;

import java.util.ArrayList;


/**
 * Course CS1011-051
 * Fall 2020-2021
 * District purpose: implementing district using array lists
 *
 * @author Malisa denise
 * @version created on 11/11/2020 at 16:08
 */
public class District {

    private int numLots;
    ArrayList<ParkingLot> lots;


    int timeClosed;
    int timeOpen;
    int totalTimeClosed; // total time closed for all lots
    int previousTime;
    int totalTime;


    /**
     * Set up a district with parking lots.
     */
    public District() {
        numLots = 0;
        lots = new ArrayList<>();
    }

    /**
     * method that adds parking lots to the district
     * @param name of the parking lot
     * @param capacity of the parking lot
     * @return the index of the lot
     */

    public int addLot(String name, int capacity) {
        lots.add(new ParkingLot(name, capacity));
        numLots++;

        return lots.size()-1;

    }

    /**method that returns the position of a lot
     * and null if it is out of range
     * @param index position in the arrayList
     * @return the index of the a lot in the district
     */

    public ParkingLot getLot(int index) {

        if (index >= 0 && index <= lots.size()) {
            return lots.get(index);
        }
        return null;
    }

        /**
         * Returns the number of remaining parking spots in the district
         *
         * @return the number of remaining parking spots in the district
         */
    public int getNumberOfSpotsRemaining() {
        int totalAvailableParking = 0;
        for (int i = 0; i < numLots; i++){
            totalAvailableParking += lots.get(i).getNumberOfSpotsRemaining();
        }
        return totalAvailableParking;
    }

        /**
         * Returns the amount of time all lots have been
         * simultaneously closed.
         *
         * @return number of minutes all lots have been closed
         */
    public int getMinutesClosed() {
        return totalTimeClosed;
    }


        /**
         * Checks the status of all lots in the district and
         * returns true if they are all closed and false otherwise.
         *
         * @return whether all lots in the district are closed
         */
    public boolean isClosed() {
        int numberOfLotsClosed = 0;

        for (int i = 0; i < numLots; i++){
            if (lots.get(i).isClosed()) {
                numberOfLotsClosed += 1;
                if (numberOfLotsClosed == numLots) {
                    return true;
                }
            }
        }
        return false;
    }



        /**
         * Record a vehicle entering a lot at a specified timestamp.
         * <p></p>
         * This calls ParkingLot.markVehicleEntry for the lot corresponding
         * to lotNumber (e.g., if lotNumber==1, call markVehicleEntry on lot1).
         * <p></p>
         * If lotNumber is out of range, the method should return without
         * doing anything else.
         *
         * @param lotNumber Number of lot
         * @param timestamp Entry timestamp in minutes since all lots were opened.
         */
    public void markVehicleEntry(int lotNumber, int timestamp) {
        boolean alreadyClosed;

        alreadyClosed = isClosed();
        if (previousTime <= timestamp) {
            lots.get(lotNumber).markVehicleEntry(timestamp);

            if (isClosed() && !alreadyClosed) {
                timeClosed = timestamp;
            }
        }
        previousTime = timestamp;
    }


        /**
         * Record a vehicle exiting a lot at a specified timestamp.
         * <p></p>
         * This calls ParkingLot.markVehicleExit for the lot corresponding
         * to lotNumber (e.g., if lotNumber==1, call markVehicleExit on lot1).
         * <p></p>
         * If lotNumber is out of range, the method should return without
         * doing anything else.
         *
         * @param lotNumber Number of lot
         * @param timestamp Exit timestamp in minutes since all lots were opened.
         */
    public void markVehicleExit(int lotNumber, int timestamp) {
        boolean alreadyClosed;

        alreadyClosed = isClosed();

        if (previousTime <= timestamp) {
            lots.get(lotNumber).markVehicleExit(timestamp);
            if (!(isClosed()) && alreadyClosed) {
                timeOpen = timestamp;
                totalTime = timeOpen - timeClosed;
                totalTimeClosed += totalTime;
            }
            previousTime = timestamp;
        }
    }

    /**
     * method that displays output message
     * @return output statement
     */
    public String toString(){
        String outputStatement = "";

        outputStatement += "District status:\n";
        for (int i = 0; i < numLots; i++){
            outputStatement += "  " + lots.get(i).toString()+ "\n";
        }
        return outputStatement;
    }

}
