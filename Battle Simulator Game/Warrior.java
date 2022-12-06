/*
 * Course: CS1011-051
 * Fall 2020-2021
 * File header contains class Warrior
 * Name: Malisa 2
 * Created 21/10/2020
 */
package week7;


/**
 * Course CS1011-051
 * Fall 2020-2021
 * Warrior purpose: Warrior class
 *
 * @author malisa
 * @version created on 21/10/2020 at 13:42
 */

public class Warrior {

    private int hitPoints;
    private Die d20 = new Die(20);
    private Die d10 = new Die(10);
    private Die d8 = new Die(8);
    private Die d4 = new Die(4);


    /**
     * constructor for warrior
     */
    public Warrior() {
        this.hitPoints = setInitialHitPoints();
    }


    /**
     * method to calculate hit points after attacks
     * @return hit points
     */
    public int getHitPoints(){
        return hitPoints;
    }


    /**
     * method to calculate damage to be taken by warrior
     * @param damage damage that has been done to warrior
     */
    public void takeDamage(int damage){
        hitPoints -= damage;
    }

    /**
     * This method handles the attack logic
     * @return the amount of damage an attack has caused, 0 if the attack misses or
     *         total points if the attack was successful
     * @param type the type of attack chosen by the warrior
     */
    public int attack(int type){
        int total = 0;

        if (type == 1){
            d20.roll();
            if (d20.getCurrentValue() >= 12){
                for (int x = 0; x < 2; x++){
                    d8.roll();
                    total = d8.getCurrentValue();
                }
                System.out.println("You have wounded the mugwump with your " +
                        "trusty sword for "+ total+ " points of damage!");
            } else {
                System.out.println("You swing your sword and miss the foul creature!");
                return 0;
            }
        } else if (type==2){
            d20.roll();
            if (d20.getCurrentValue() >= 8){
                d4.roll();
                total = (d4.getCurrentValue());

                System.out.println("You hit the Mugwump with your Shield of Light for "+
                           total+ " points of damage!");
            } else{
                System.out.println("You tried to hit the Mugwump with your shield and miss");
                return 0;
            }
        }
        return total;
    }

   /**
     * method to set the set the initial
     * hit point of warrior
     * @return initial hit points
     */
    private int setInitialHitPoints(){
        int total = 0;
        for (int x = 0; x < 6; x++){
            this.d10.roll();
            total += this.d10.getCurrentValue();
        }
        return total;
    }


}
