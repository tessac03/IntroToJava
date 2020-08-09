/* *************************************************************************************
 * Description: Takes an integer command line argument n, and rolls 10 fair six-sided
 * dice n time. Sums the ten dice at each of the n-rolls, then prints  a text histogram
 * showing the number of times each possible total (10-60) occurs.
 ************************************************************************************ */

import java.util.Random;

public class RollDice {
    public static void main(String[] args){
    	//Define variables for number of die rolls, number of die and number of sides,
    	//and variable for summing the die on each set of rolls. Define an array for 
    	//holding the tally of the number of times each possible sum occurs*/
        int n=Integer.parseInt(args[0]);
        int sides=6, numDie=10;
        int dice;
        int[] tally=new int[sides*numDie];
			
        //Initialize a random number generator for generating the random die rolls
        Random random=new Random();
		
        //While loop to roll the die n number of times and add 1 to the tally count 
        //in the array at the corresponding entry.
        while(n>0){
            dice=0;
            //for loop to generate the appropriate number of random sides of the dice
            //and add the count to the sum of the dice
            for(int j=numDie; j>0; j--){
                dice+=(random.nextInt(sides)+1);
            }
            tally[dice-1]+=1;
            n--;
        }
        
        //for loop to print out the entries of the array storing the tally counts
        for(int i=9; i<(sides*numDie); i++){
            System.out.print((i+1)+": ");
            for(int j=0;j<tally[i];j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
