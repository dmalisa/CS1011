
/*
 * Course: CS1011-051
 * Fall 2020-2021
 * File header contains class CalculateTaxes
 * Name: denise
 * Created 2020/09/22
 */
package malisad;

/*
  Course CS1011-051
  Fall 2020-2021
  CalculateTaxes purpose: to calculate taxes for 2020

  @author denise
 * @version created on 2020/09/22 at 23:54
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class CalculateTaxes {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);// to get input from user

        System.out.println("Are you a single filer or a married joint filer," + "(enter s or j)");// asking for users status
        String status = input.nextLine();
        System.out.println("Enter an estimate of your earned income for 2019");
        double earnedIncome = input.nextDouble();// getting user income


        char single = status.charAt(0); // to represent single status
        char marriedJoint = status.charAt(0); // to represent married status
        double rate1 = (float) 0.10;
        double taxOwing = 0.0;  // for value of tax that is owed by flier

        float effectiveTaxRate ; //  for calculated effective tax

        // formatting number to two decimal places
        DecimalFormat df = new DecimalFormat("#,###,###.00");


        if (single == 's') // this if statement includes all possible income for single filers and
                            // calculates and outputs their tax owed and their effective rate

            if (earnedIncome > 0 && earnedIncome <= 9_700) {
                taxOwing = rate1 * earnedIncome;
            } else if (earnedIncome >= 9_701 && earnedIncome <= 39_475) {
                taxOwing = (rate1 * 9700) + (0.12 * 29775);
            } else if (earnedIncome >= 39_476 && earnedIncome <= 84_200) {
                taxOwing = (rate1 * 9700) + (0.12 * 29775) + (0.22 * (earnedIncome - 39475));
            } else if (earnedIncome >= 84_201 && earnedIncome <= 160_725) {
                taxOwing = (rate1 * 9700) + (0.12 * 29775) + (0.22 * 44725) + (0.24 * (earnedIncome - 84200));
            } else if (earnedIncome >= 160_726 && earnedIncome <= 204_100) {
                taxOwing = (rate1 * 9700) + (0.12 * 29775) + (0.22 * 44725) + (0.24 * 76525) + (0.32 * (earnedIncome - 160_725));
            } else if (earnedIncome >= 204_101 && earnedIncome <= 510_300) {
                taxOwing = (rate1 * 9700) + (0.12 * 29775) + (0.22 * 44725) + (0.24 * 76525) + (0.32 * 43375) + (0.35 * (earnedIncome - 204_100));
            } else if (earnedIncome >= 510_301) {
                taxOwing = (rate1 * 9700) + (0.12 * 29775) + (0.22 * 44725) + (0.24 * 76525) + (0.32 * 43375) + (0.35 * 306200) + (0.37 * (earnedIncome - 510300));
            }


        if (marriedJoint == 'j') // this if statement includes all possible income for single filers and
                                  // calculates and outputs their tax owed and their effective rate

            if (earnedIncome > 0 && earnedIncome <= 19_400) {
                taxOwing = rate1 * earnedIncome;
            } else if (earnedIncome >= 19_401 && earnedIncome <= 78_950) { // a tax bracket to compare the earned income to and see which bracket it fits into.
                taxOwing = (rate1 * 19_400) + (0.12 * (earnedIncome-19_400));
            } else if (earnedIncome >= 78_951 && earnedIncome <= 16_8400) {
                taxOwing = (rate1 * 19_400) + (0.12 * 59_550) + (0.22 * (earnedIncome - 78_950));
            } else if (earnedIncome >= 16_8401 && earnedIncome <= 321_450) {
                taxOwing =(rate1 * 19_400) + (0.12 * 59_550) + (0.22 * 89_450) + (0.24 * (earnedIncome - 168_400));
            } else if (earnedIncome >= 321_451 && earnedIncome <= 408_200) {
                taxOwing= (rate1 * 19_400) + (0.12 * 59_550) + (0.22 * 89_450) +(0.24 * 153050)+ (0.32 * (earnedIncome - 321_450));
            } else if (earnedIncome >= 408_201 && earnedIncome <= 612_350) {
                taxOwing= (rate1 * 19_400) + (0.12 * 59_550) + (0.22 * 89_450) + (0.24 * 153050) + (0.32*86750) + (0.35 *( earnedIncome- 408_200));
            } else if (earnedIncome >= 612_351) {
                taxOwing= (rate1 * 19_400) + (0.12 * 59_550) + (0.22 * 89_450) + (0.24 * 153050) + (0.32*86750) + (0.35 * 204_150) + (0.37 * (earnedIncome - 612_350));
            }

        effectiveTaxRate = (float) (taxOwing / earnedIncome) * 100;
        System.out.println("Your estimated taxes are: " + "$" + df.format(taxOwing));
        System.out.println("This results in an " + df.format(effectiveTaxRate) + "% effective tax rate " );
          /* statements to be displayed to the user after they have entered
         their status and in come and tax owed and effective rate is output*/

        //code for unit testing of class CalculateTaxes
        //or delete this main method

    }
}