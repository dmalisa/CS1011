/*
 * Course: CS1011-051
 * Fall 2020-2021
 * File header contains class Die
 * Name: Malisa
 * Created 21/10/2020
 */
package week7;

import java.util.Random;

/**
 * Course CS1011-051
 * Fall 2020-2021
 * Die purpose: die operation for battle simulator 3000
 *
 * @author Malisa
 * @version created on 21/10/2020 at 01:29
 */
public class Die {

    private int numSides;
    private int currentValue;
    private Random generator = new Random();
    final int CONSTANT_NUM_SIDES = 6;
    final int UPPERBOUND = 100;

    /**
     * This method checks the range of the die number of sides
     * @param numSides checks that die number of sides
     * is within the range
     */
    public Die(int numSides){
        if (numSides >= 2 && numSides <= UPPERBOUND){
            this.numSides = numSides;
        } else {
            this.numSides = CONSTANT_NUM_SIDES;
        }
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    /**
     * This method will give current value of die
     * after it has been rolled
     */
    public void roll(){
        currentValue = generator.nextInt(numSides)+1;
    }

}
