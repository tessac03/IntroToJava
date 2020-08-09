/* *************************************************************************************
 * Description: Takes two integer command line argument n and trials, then simulates 
 * trials many random walks each of n-steps on a graph beginning at the origin.
 * At each trial the code computes the squared distance from the origin and the final
 * point in the random walk which is used at the end of all of the trials to compute
 * the mean squared distance.
 ************************************************************************************ */

public class RandomWalkers {
    public static void main(String[] args){
        //Initialize variables n and trials using the two command line arguments and 
        //create variables x, y, set to 0, to chart the random walk on the graph and
        //a variable for computing the sum of the squared distances over the trials
        int n=Integer.parseInt(args[0]), trials=Integer.parseInt(args[1]);
        int x=0, y=0;
        double totalSqrDist=0;
        
        //For loop to generate trials many random walks and then add the squared 
        //distance of each walk to the total sum of totalSqeDist
        for(int i=trials; i>0; i--){
            int j=n;
            //while loop to generate a random walk of n many steps
            while(j>0){
                double r=Math.random();
                if(r<0.25) x--;
                else if(r<0.5)x++;
                else if(r<0.75)y--;
                else y++;
                j--;
            }
            totalSqrDist+=(x*x)+(y*y);
            x=0;
            y=0;
        }
        
        //Compute and print out the mean squared distance
        System.out.println("Mean squared distance = "+totalSqrDist/trials);
    }
}
