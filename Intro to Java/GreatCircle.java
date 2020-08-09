/* *************************************************************************************
 * Description: Takes in four command line arguments for the latitude and longitude of 
 * two points on the earth's surface, then computes and prints out the great circle
 * distance between them.
 ************************************************************************************ */

public class GreatCircle {
    public static void main(String[] args){
        //Create and initialize variables in degrees for the two points using the 
        //command line arguments
        double x1, y1, x2, y2;
        x1=Double.parseDouble(args[0]);
        y1=Double.parseDouble(args[1]);	
        x2=Double.parseDouble(args[2]);
        y2=Double.parseDouble(args[3]);
        
        //Convert the points to radians
        x1=Math.toRadians(x1);
        y1=Math.toRadians(y1);
        x2=Math.toRadians(x2);
        y2=Math.toRadians(y2);
        
        //Compute the trig functions needed
        double sinx1, sinx2, cosx1, cosx2, cosy, arccos;
        sinx1=Math.sin(x1);
        sinx2=Math.sin(x2);
        cosx1=Math.cos(x1);
        cosx2=Math.cos(x2);
        cosy=Math.cos(y1-y2);
        arccos=Math.acos(sinx1*sinx2+cosx1*cosx2*cosy);
        
        //Convert back to degrees then create and compute the final value of the
        //the great circle and print it out
        arccos=Math.toDegrees(arccos);
        double distance=60*arccos;
        System.out.println(distance+" natuical miles");
	}
}
