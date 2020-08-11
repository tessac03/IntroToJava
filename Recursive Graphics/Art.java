/* *************************************************************************************
 * Description: Takes an integer command line argument n and recuresively draws an 
 * abstract picture using circles and the Standard Draw class.
 ************************************************************************************ */
public class Art {
	private static void art(int n){
		if (n==1){
			StdDraw.circle(0,0,1);
		}else if (n!=1 && (n%2)!=0){
			StdDraw.circle(n-1, n-1, 1);
			StdDraw.circle(n-1, 1-n, 1);
			StdDraw.circle(1-n, 1-n, 1);
			StdDraw.circle(1-n, n-1, 1);
			
			StdDraw.circle(n-1, 0, 1);
			StdDraw.circle(-n+1, 0, 1);
			StdDraw.circle(0, n-1, 1);
			StdDraw.circle(0, -n+1, 1);
			art(n-1);
		}else{
			StdDraw.circle(n-1, 0, 1);
			StdDraw.circle(-n+1, 0, 1);
			StdDraw.circle(0, n-1, 1);
			StdDraw.circle(0, -n+1, 1);
			art(n-1);
		}
	}
	
	public static void main(String[] args){
		int n=Integer.parseInt(args[0]);
		StdDraw.setXscale(-7,7);
    	StdDraw.setYscale(-7, 7);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        art(n);
	}
}
