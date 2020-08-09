/* *************************************************************************************
 * Description: Takes an integer command line argument n and simulates a random walk of
 * n many steps on a graph beginning at the origin and computes the squared distance
 * from the final point in the walk from the origin.
 ************************************************************************************ */

public class RandomWalker {
    public static void main(String[] args){
        //Creates variable n from the command line argument input to be used as the
        //number of steps to take, and variables x,y to chart the random walk
        int n = Integer.parseInt(args[0]);
        int x=0, y=0;
        
        //while loop to generate the n many random steps and to print out each point
        //in the step
        while(n>0){
            System.out.println("("+x+", "+y+")");
            double r=Math.random();
            if(r<0.25) x--;
            else if(r<0.5)x++;
            else if(r<0.75)y--;
            else y++;
            n--;
        }
        //print out the final point in the random walk and compute and print out 
        //the squared distance
        System.out.println("("+x+", "+y+")");
        System.out.println("squared distance = "+((x*x)+(y*y)));
    }
}
