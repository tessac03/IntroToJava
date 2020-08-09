/* *************************************************************************************
 * Description: Takes integer command line argument n and recursively plots a Sierpinski 
 * triangle of order n to standard drawing.
 ************************************************************************************ */

public class Sierpinski {
    //  Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length){
    	return (length*Math.sqrt(3))/2;
    }

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void filledTriangle(double x, double y, double length){
    	double[]xcoord={x, x-(length/2), x+(length/2)};
    	double[]ycoord={y,(y+height(length)),(y+height(length))};
    	StdDraw.filledPolygon(xcoord, ycoord);
    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length){
    	//base case when level=1
    	if(n==1){
    		filledTriangle(x,y,length);
    	}else{
    		filledTriangle(x,y,length);
    		sierpinski(n-1, x, y+height(length), length/2);
    		sierpinski(n-1, x-length/2, y, length/2 );
    		sierpinski(n-1, x+length/2, y, length/2);
    	}
    }

    //  Takes an integer command-line argument n;
    //  draws the outline of an equilateral triangle (pointed upwards) of length 1;
    //  whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    //  draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args){
    	int n=Integer.parseInt(args[0]);
    	StdDraw.setXscale(-0.1,1.1);
    	StdDraw.setYscale(-0.1, 1);
    	double[]x={0,1,0.5};
    	double[]y={0,0,Math.sqrt(3)/2};
    	StdDraw.polygon(x, y);
    	sierpinski(n,0.5,0,0.5);
    }
}
