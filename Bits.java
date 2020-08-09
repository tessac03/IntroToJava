/* *************************************************************************************
 * Description: Take a positive integer input from the command line argument and compute the
 * number of times it can be divided by 2 before it is less than 1.
 ************************************************************************************ */

public class Bits {
    public static void main(String[] args){
        //Create and initialize a variable for the integer input, and return an error
        //if the value is negative
        int n = Integer.parseInt(args[0]);
        if(n<0){
            System.out.println("Illegal input");
            return;
        }
        
        //Use a while loop to divide the input, update the value and keep track of
        //the count for the number of times the number can be divided
        int count=0;
        while(n>=1){
            n=n/2;
            count++;
        }
        
        //Print out the count 
        System.out.println(count);
    }
}
