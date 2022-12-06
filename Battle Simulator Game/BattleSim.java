/*
 * Course: CS1011-051
 * Fall 2020-2021
 * File header contains class BattleSim
 * Name: Malisa 2
 * Created 21/10/2020
 */
package week7;

/*
 * Course CS1011-051
 * Fall 2020-2021
 * BattleSim purpose: BattleSim 3000 class
 *
 * @author Malisa 2
 * @version created on 21/10/2020 at 14:02
 */

import java.util.Scanner;
/**
 * BattleSim Driver for Battle Simulator 3000
 */
public class BattleSim {

    /**
     * Ten-sided die to be used for checking initiative by all classes
     */
    public static final Die INITIATIVE_DIE = new Die(10);

    public static void main(String[] args) {

        // Include any variable that will need to be accessed throughout the program here
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        // sentinel value for the game loop
        boolean play = true;
        // String used to determine the winner of the epic battle
        String victor = "";
        // game loop
        do {

            intro(); // prints the introduction and rules
            // Initialize the Warrior and Mugwump classes, set the current victor to "none"
            Warrior warrior = new Warrior();
            Mugwump mugwump = new Mugwump();
            victor = "none";

            // while neither combatant has lost all of their hit points, report status and battle!
            while (victor.equalsIgnoreCase("none")) {
                report(warrior, mugwump);
                victor = battle(warrior, mugwump, in);
                System.out.println("the victor is\n"+ victor);
            }
            victory(victor); //declaring  the winner

            boolean again;
            //playAgain(in);
           // boolean again = playAgain(in);
            again = playAgain(in2); // asking user if they want to play again
            play = again;
        } while (play);
        System.out.println("Thank you for playing the game!");
        // Thank the user for playing your game

    }

    /**
     * This method displays the introduction to the game and gives a description of the rules.
     */
    private static void intro() {

        // introduction for game
        System.out.println("Welcome to Battle Simulator 3000!" +
                " The world's more low tech battle simulator\n" +
                "You are a Valiant Warrior defending your humble village from" +
                " an evil Mugwump! Fight bravely,\nor the citizens " +
                "of your town will be the Mugwump's dinner!\n");
        System.out.println("You have your Trusty Sword, which deals decent damage," +
                " but can be tough to hit with sometimes. \n" +
                "You also have your Shield of Light, which is not as strong as your sword," +
                " but is easier to deal \ndamage with.\n" +
                "\nLet the epic battle begin!\n");

    }

    /**
     * This method handles the battle logic for the game.
     *
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     * @return The name of the victor, or "none", if the battle is still raging on
     */
    private static String battle(Warrior warrior, Mugwump mugwump, Scanner in) {
        // determine who attacks first (Roll! For! Initiative!) and store the result
        int firstPlayer = initiative();
        int warriorAttacking;
        String gameWinner = "none";

        while (mugwump.getHitPoints() > 0 && warrior.getHitPoints() > 0) {

            if (firstPlayer == 1) {
                System.out.println("\nWarrior goes first!");
                warriorAttacking = warrior.attack(attackChoice(in));
                mugwump.takeDamage(warriorAttacking);
                report(warrior, mugwump);

                if (mugwump.getHitPoints() > 0) {
                    mugwump.attack();
                    warrior.takeDamage(mugwump.attack());
                    report(warrior, mugwump);
                }

            } else {
                System.out.println("\nMugwump goes first!");
                mugwump.attack();
                warrior.takeDamage(mugwump.attack());
                report(warrior, mugwump);
                
                if (warrior.getHitPoints() > 0) {
                    warriorAttacking = warrior.attack(attackChoice(in));
                    mugwump.takeDamage(warriorAttacking);
                    report(warrior, mugwump);
                }
            }
        }

        if (mugwump.getHitPoints() < 1) {
            gameWinner = "warrior";
        } else if (warrior.getHitPoints() < 1){
            gameWinner = "mugwump";
        }


    // If neither combatant is defeated, the battle rages on!
        return gameWinner;
    }

    /**
     * This method reports the status of the combatants
     *
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     */
    private static void report(Warrior warrior, Mugwump mugwump) {
        System.out.println("warrior HP: "+warrior.getHitPoints());
        System.out.println("mugwump HP: "+mugwump.getHitPoints());
    }

    /**
     * This method asks the user what attack type they want to use and returns the result
     * @param in input from user
     * @return 1 for sword, 2 for shield
     */
    private static int attackChoice(Scanner in) {

        int choice;

        System.out.println("\nHow would you like to attack? " +
                "\n1. Your Trusty Sword\n2. Your Shield of Light"+
                "\nEnter choice:");
        choice = in.nextInt();
        System.out.println("\nYou chose: "+choice);

        while (!(choice== 1 || choice == 2)){
            System.out.println("\nHow would you like to attack? " +
                    "\n1. Your Trusty Sword\n2. Your Shield of Light"+
                    "\nEnter choice:");
            choice = in.nextInt();
            System.out.println("\nYou chose: "+choice);
        }
        return choice;
    }


    /**
     * Determines which combatant attacks first and returns the result. In the case of a tie,
     * re-roll.
     *
     * @return 1 if the warrior goes first, 2 if the mugwump goes first
     */
    private static int initiative() {
        INITIATIVE_DIE.roll(); // initial roll value for warrior
        int initialWarrior = INITIATIVE_DIE.getCurrentValue();
        INITIATIVE_DIE.roll(); // initial roll value for mugwump
        int mugwump = INITIATIVE_DIE.getCurrentValue();

        while (mugwump == initialWarrior){ // rolls again in the case of a tie
            INITIATIVE_DIE.roll();
            initialWarrior = INITIATIVE_DIE.getCurrentValue();
            INITIATIVE_DIE.roll();
            mugwump = INITIATIVE_DIE.getCurrentValue();
        }
        if (mugwump > initialWarrior){
            return 1; // if initial roll for warrior is greater 1 is returned
        } else{
            return 2; // if initial roll for mugwump is greater, 2 is returned
        }

    }

    /**
     * This method declares the victor of the epic battle
     *
     * @param victor the name of the victor of the epic battle
     */
    private static void victory(String victor) {
        if (victor.equals("\twarrior")){
            System.out.println("The citizens cheer and invite you back to town "+
                    "for a feast as thanks for saving their lives (again)!");
        } else if (victor.equals("\tmugwump")){
            System.out.println("The mugwump has killed you "+
                    "and is making its way into the village!");
        }

    }

    /**
     * This method asks the user if they would like to play again
     *
     * @param in2 Scanner
     * @return true if yes, false otherwise
     */
    private static boolean playAgain(Scanner in2) {

        System.out.println("\nWould you like to play again? (yes/no)");
        String answer = in2.nextLine();

        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
            return true;
        } else if (answer.equalsIgnoreCase("no")|| answer.equalsIgnoreCase("n")){
            return false;
        }
        return false;
    }


}