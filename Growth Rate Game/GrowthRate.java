/*
 * Course: CS1011-051
 * Fall 2020-2021
 * File header contains class GrowthRate
 * Name: denise malisa
 * Created 7/10/2020
 */
package week5;

import java.util.Scanner;

/**
 * Course CS1011-051
 * Fall 2020-2021
 * GrowthRate purpose: A game to generate which option is more profitable
 *
 * @author denise malisa
 * @version created on 7/10/2020 at 00:30
 */

public class GrowthRate {
    public static void main(String[] args) {

        int weekEnd;
        int weekNum;
        double interest;
        int play;
        double shareValue, linear;
        double shares;
        double difference = 0;
        double difference1;


        Scanner input = new Scanner(System.in);

        System.out.println("Hello and welcome to the investment game!\n" +
                "There are two investment options to choose from:\n\n"+
                "Option 1: you deposit an amount of money into a bank account that will" +
                " return interest every month at a fixed rate." +
                "\nyou will not know the amount deposited!"+
                "\nOption 2: you will purchase shares from a company worth $2.00\n"+
                "assuming the business is doing incredible well," +
                " the share value will double each week."+
                "\n\nChoose wisely as an economic crises can occur at any given time"+
                "\nWhich option will give you the highest return on investment?\n");


        do {


            int option;
            System.out.println("Please choose option: (Enter: 1 for option 1) or (2 for option 2)");
            option = input.nextInt();


            double deposit = 5_000 * (Math.random());
            linear = deposit;
            weekEnd = (int) (40 * Math.random()+1);
            weekNum = 1;
            shareValue = 1;
            shares = 1;
            System.out.format("Week %2d Linear: $%.2f exponential: $%.2f\n",
                    weekNum, linear, shareValue);

            while (weekNum < weekEnd - 1 && shareValue < linear) {

                weekNum++;
                interest = deposit * (1 + (0.26 * 0.5));
                linear = linear + interest;
                shares = shares * 2;
                shareValue = shares;
                difference = Math.abs((linear + deposit) - (shareValue * 2));

                System.out.format("Week %2d Linear: $%.2f " +
                        "exponential: $%.2f\n", weekNum, linear, shareValue);
            }
            if (linear > shareValue && option == 1) {
                System.out.format("\nThe economic crisis occurred after week %2d\n"
                        +"so you got lucky and ended up with" +
                        " an extra $%.2f\n", weekEnd, difference);
            } else if (linear > shareValue && option == 2) {
                System.out.format("\nThe economic crisis occurred after week %2d\n"
                        +"so you got unlucky and missed out on $%.2f\n", weekEnd, difference);
            }
            if (shareValue > linear && option == 1) {

                shares = 1;
                for (int x = 1; x <= weekEnd; x++){
                    interest = deposit * (1 + (0.26 * 0.5));
                    linear = linear + interest;
                    shares = shares * 2;
                    shareValue = shares;
                }
                difference1 = Math.abs(shareValue - linear);
                System.out.format("\nThe economic crisis occurred after week %2d\n"
                        +"so you got unlucky and missed out on $%.2f\n", weekEnd, difference1);
            } else if (shareValue > linear && option == 2) {

                shares = 1;
                for (int x = 1; x <= weekEnd; x++){
                    interest = deposit * (1 + (0.26 * 0.5));
                    linear = linear + interest;
                    shares = shares * 2;
                    shareValue = shares;
                }
                difference1 = Math.abs(shareValue - linear);
                System.out.format("\nThe economic crisis occurred after week %2d\n"
                        +"so you got lucky and ended up with an" +
                        " extra $%.2f\n", weekEnd, difference1);
            }

            System.out.println("\nDo you want to play again,type:'1' if yes and '0' if no");
            play = input.nextInt();
        } while (play == 1);
    }
    //code for unit testing of class GrowthRate
    //or delete this main method
}
