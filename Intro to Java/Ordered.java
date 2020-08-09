/* *************************************************************************************
 * Description: Takes three integer command line arguments and determines if the were
 * input using either strictly increasing or strictly decreasing order. Assumes the 
 * inputs are integers.
 ************************************************************************************ */

public class Ordered {
    public static void main(String[] args){
        //create three variables and assign them in order using the command line
        //argument inputs
        int a,b,c;
        a=Integer.parseInt(args[0]);
        b=Integer.parseInt(args[1]);
        c=Integer.parseInt(args[2]);
        
        //Determines whether the a,b,c are in order or not, and prints out the answer
        boolean ordered=((a<b && b<c) || (a>b && b>c));
        System.out.println(ordered);
    }
}
