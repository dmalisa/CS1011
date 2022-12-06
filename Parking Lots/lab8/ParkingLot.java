/*
 * Course: CS1011-051
 * Fall 2020-2021
 * File header contains class ParkingLot
 * Name: Malisa denise
 * Created 28/10/2020
 */
package week8;

/**
 * Course CS1011-051
 * Fall 2020-2021
 * ParkingLot purpose:
 *
 * @author Malisa denise
 * @version created on 28/10/2020 at 20:22
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

    /**
     * this method displays the status of a specific parking lot
     */
    public void displayStatus(){
        System.out.print("" +name+ " parking lot status: ");

        if (getPercentFull() > CLOSED_THRESHOLD){
            System.out.println("CLOSED");
        } else {
            System.out.println(getPercentFull() +"%");
        }
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
        return ((double)this.occupiedParking / this.capacity) * 100;
    }

    public boolean isClosed(){
        return closedStatus;
    }
    /** this method calculates the times a gate is closed and a
     * vehicle enters
     *
     * @param timestamp marks time that the gate will be opened
     */
    public void markVehicleEntry(int timestamp) {

        occupiedParking += 1;
        if (getPercentFull() >= CLOSED_THRESHOLD) {
            closedStatus = true;
            if (closedStatus) {
                timeClosed = timestamp;
            }
        }
    }

    /** this method calculates the times a gate is opened and a
     * vehicle exits
     * it calculates the total time the lot is closed
     * @param timestamp marks time that the gate will be closed
     */
    public void markVehicleExit(int timestamp){
        timeOpen = timestamp;
        occupiedParking -= 1;
        if (getPercentFull() >= CLOSED_THRESHOLD){
            closedStatus = true;
        }
        closedStatus = false;
        if (!(isClosed())){
            totalMinutesClosed = timeOpen - timeClosed;
            totalTime += totalMinutesClosed;
        }
    }

}
