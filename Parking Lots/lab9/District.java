/*
 * Course: CS1011-051
 * Fall 2020-2021
 * File header contains class District
 * Name: Malisa 2
 * Created 4/11/2020
 */
package week9;

/**
 * Course CS1011-051
 * Fall 2020-2021
 * District purpose:
 *
 * @author Malisa denise
 * @version created on 4/11/2020 at 21:28
 */

/**
 * Manages parking lots within a district.
 * @author denise
 */
public class District {

    private week9.ParkingLot[] lots;
    private int numLots;
    public static final int MAX_LOTS = 20;


    int timeClosed;
    int timeOpen;
    int totalTimeClosed; // total time closed for all lots
    int previousTime;
    int totalTime;


    /**
     * Set up a district with three parking lots.
     */
    public District() {
        lots = new week9.ParkingLot[MAX_LOTS];
        numLots = 0;
    }

    public int addLot(String name, int capacity) {
        int newIndex = numLots;
        if (newIndex < MAX_LOTS) {
            lots[newIndex] = new week9.ParkingLot(name, capacity);
            numLots++;
        }
        // return the index of the new lot or -1 if the lot was not added.
        return newIndex < MAX_LOTS ? newIndex : -1;
    }

    public week9.ParkingLot getLot(int index) {

        if (index >= 0 && index <= MAX_LOTS) {
            return lots[index];
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
            totalAvailableParking += lots[i].getNumberOfSpotsRemaining();
        }
        return totalAvailableParking;
    }

    /**
     * Returns the amount of time all three lots have been
     * simultaneously closed.
     *
     * @return number of minutes all three lots have been closed
     */
    public int getMinutesClosed() {
        return totalTimeClosed;
    }

    /**
     * Checks the status of all three lots in the district and
     * returns true if they are all closed and false otherwise.
     *
     * @return whether all three lots in the district are closed
     */
    public boolean isClosed() {
        int numberOfLotsClosed = 0;

        for (int i = 0; i < numLots; i++){
            if (lots[i].isClosed()) {
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
     * @param lotNumber Number of lot (should be 1, 2, or 3)
     * @param timestamp Entry timestamp in minutes since all lots were opened.
     */
    public void markVehicleEntry(int lotNumber, int timestamp) {

        boolean alreadyClosed;

        alreadyClosed = isClosed();
        if (previousTime <= timestamp) {
            lots[lotNumber].markVehicleEntry(timestamp);

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
     * @param lotNumber Number of lot (should be 1, 2, or 3)
     * @param timestamp Exit timestamp in minutes since all lots were opened.
     */
    public void markVehicleExit(int lotNumber, int timestamp) {

        boolean alreadyClosed;


        alreadyClosed = isClosed();

        if (previousTime <= timestamp) {
            lots[lotNumber].markVehicleExit(timestamp);
            if (!(isClosed()) && alreadyClosed) {
                timeOpen = timestamp;
                totalTime = timeOpen - timeClosed;
                totalTimeClosed += totalTime;
            }
            previousTime = timestamp;
        }
    }


    public String toString() {
        String outputStatement = "";

        outputStatement += "District status:\n";
        for (int i = 0; i < numLots; i++){
            outputStatement += "  " + getLot(i).toString()+ "\n";
        }
        return outputStatement;
    }
}
