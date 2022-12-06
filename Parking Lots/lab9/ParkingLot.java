/*
 * Course: CS1011-051
 * Fall 2020-2021
 * File header contains class ParkingLot
 * Name: Malisa 2
 * Created 4/11/2020
 */
package week9;

import java.text.DecimalFormat;

/**
 * Course CS1011-051
 * Fall 2020-2021
 * ParkingLot purpose: multiple lots per district
 *
 * @author Malisa 2
 * @version created on 4/11/2020 at 21:24
 */
public class ParkingLot {

    public static final double CLOSED_THRESHOLD = 80.0;
    private final String name;

    private int capacity;
    private Boolean closedStatus = false;
    private int availableParking;
    private int occupiedParking;
    private int totalMinutesClosed;
    private int timeClosed;
    private int timeOpen;
    private int totalTime;
    private int previousTime;

    DecimalFormat df = new DecimalFormat("#.#");

    /**
     * this is a constructor of a parking lot
     * it defaults the name to test
     * @param capacity is the number of cars a lot can have
     */
    public ParkingLot(int capacity){
        this.name = "test";
        this.capacity = capacity;
    }

    /**
     * this is a constructor of a parking lot
     * @param name is the name if the parking lot
     * @param capacity is the number of cars a lot can have
     */
    public ParkingLot(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }


    public int getMinutesClosed(){
        return totalTime;

    }

    public String getName(){
        return this.name;
    }

    /**This method calculates the number of parking spaces
     * that can be occupied in a lot
     * i.e those that are empty
     * @return available parking spaces in the lot
     */

    public int getNumberOfSpotsRemaining() {
        availableParking = this.capacity - this.occupiedParking;
        return availableParking;
    }

    public double getPercentFull(){
        return ((double)this.occupiedParking / (double)this.capacity) * 100;
    }

    /**
     * method that closes the gate when percent full is reached
     * @return closed status
     */
    public boolean isClosed(){
        closedStatus = getPercentFull() >= CLOSED_THRESHOLD;
        if (getPercentFull() >= CLOSED_THRESHOLD){
            closedStatus = true;
        } else {
            closedStatus = false;
        }
        return closedStatus;
    }
    /** this method calculates the times a gate is closed and a
     * vehicle enters
     *
     * @param timestamp marks time that the gate will be opened
     */
    public void markVehicleEntry(int timestamp) {
        boolean alreadyClosed;

        alreadyClosed = isClosed();
        if (previousTime <= timestamp) {
            occupiedParking += 1;
            if (getPercentFull() >= CLOSED_THRESHOLD) {
                closedStatus = true;
                if (closedStatus && !alreadyClosed) {
                    timeClosed = timestamp;
                }
            }
            previousTime = timestamp;
        }
    }


    /** this method calculates the times a gate is opened and a
     * vehicle exits
     * it calculates the total time the lot is closed
     * @param timestamp marks time that the gate will be closed
     */
    public void markVehicleExit(int timestamp) {
        boolean alreadyClosed;

        alreadyClosed = isClosed();
        if (previousTime <= timestamp) {

           // timeOpen = timestamp;
            occupiedParking -= 1;

            if (!(isClosed()) && alreadyClosed) {
                totalMinutesClosed = timestamp - timeClosed;
                totalTime += totalMinutesClosed;
            }
        }
    }
    /**
     * this method displays the status of a specific parking lot
     * @return output statement of the different parking lots
     */

    public String toString(){
        String outputStatement;

        outputStatement = "Status for "+ name +" parking lot: "
                +occupiedParking+" vehicles ("+df.format(getPercentFull()) + "%)";
        if (getPercentFull() >= CLOSED_THRESHOLD){
            outputStatement = "Status for "+ name +" parking lot: "
                    +occupiedParking+" vehicles (CLOSED)";
        }
        return outputStatement;
    }
}
