/*
 * Course: CS1011-051
 * Fall 2020-2021
 * File header contains class Mugwump
 * Name: Malisa
 * Created 21/10/2020
 */
package week7;


/**
 * Course CS1011-051
 * Fall 2020-2021
 * Mugwump purpose:
 *
 * @author Malisa
 * @version created on 21/10/2020 at 15:28
 */

public class Mugwump {

    private int hitPoints;
    private int maxHitPoints;
    private Die d100= new Die(100);
    private Die d20= new Die(20);
    private Die d10= new Die(10);
    private Die d6 = new Die(6);


    /**
     * method to create dice for Mugwump
     */
    public Mugwump(){
        maxHitPoints = setInitialHitPoints();
        hitPoints = maxHitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * method to calculate damage to be taken by the Mugwump
     * and deduct that from the total hit points
     * @param damage damage that has been done to the Mugwump
     */
    public void takeDamage(int damage){
        hitPoints -= damage;
    }


    /**
     * This method handles the attack logic
     * @return the amount of damage an attack has caused, 0 if the attack misses or
     *         a negative amount of damage if the Mugwump heals itself
     */
    public int attack() {
        int total = 0;
        // get attack type from ai
        int attack = ai();
        // roll attack die
        if (attack == 1){
            d20.roll();
            if (d20.getCurrentValue()>= 12){
                for (int x = 0; x < 2; x++){
                    d6.roll();
                    total = d6.getCurrentValue();
                }
                System.out.println("Mugwump tares at you with his razor sharp claws! "+
                        "for " +total+" points of damage!");
                return total;
            } else {
                System.out.println("Mugwump tries to tare you apart with his claws and fails!");
                return 0;
            }

        } else if (attack == 2){
            d20.roll();
            if (d20.getCurrentValue() >= 16){
                for (int x = 0; x < 3; x++){
                    d6.roll();
                    total = d6.getCurrentValue();
                }
                System.out.println("Mugwump snaps at you with his fangs! "+
                        "for "+total +" points of damage!");
                return total;
            } else {
                System.out.println("The Mugwump snaps at you and misses!");
            }
            return 0;
        } else if (attack == 3) {
            System.out.println("Mugwump licks his or her wounds and heals!");
            d6.roll();
            total = d6.getCurrentValue();
            if (hitPoints < maxHitPoints) {
                this.hitPoints += total;
            }
        }
        return 0;
    }


    private int setInitialHitPoints(){
        int total =0;
        for (int x = 0; x < 10; x++ ) {
            d10.roll();
            total += d10.getCurrentValue();
        }
        return total;
    }



    /**
     * This method determines what action the Mugwump performs
     * @return 1 for a Claw attack, 2 for a Bite, and 3 if the Mugwump licks its wounds
     */
    private int ai() {

        d100.roll();
        if (d100.getCurrentValue() <= 10){
            return 3;
        }
        if (d100.getCurrentValue() > 10 && d100.getCurrentValue()<= 25){
            return 2;
        } else {
            return 1;
        }

    }



}

