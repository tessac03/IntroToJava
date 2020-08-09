/* *************************************************************************************
 * Description: A library of static methods that performs various geometric transforms
 * on polygons.
 ************************************************************************************ */

public class Transform2D {
    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array){
    	double[]copy=array;
    	return copy;
    }

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha){
    	int i=0;
    	while(i<x.length){
    		x[i]=x[i]*alpha;
    		y[i]=y[i]*alpha;
    		i++;
    	}   	
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy){
    	int i=0;
    	while(i<x.length){
    		x[i]+=dx;
    		y[i]+=dy;
    		i++;
    	}
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta){
    	int i=0;
    	while(i<x.length){
    		double xi=x[i];
    		double yi=y[i];
    		x[i]=xi*Math.cos(Math.toRadians(theta))-yi*Math.sin(Math.toRadians(theta));
    		y[i]=yi*Math.cos(Math.toRadians(theta))+xi*Math.sin(Math.toRadians(theta));
    		i++;
    	}
    }
}
