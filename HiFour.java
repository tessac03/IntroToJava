/* *************************************************************************************
 * Description: Takes four names as command line arguments and prints them out in 
 * reverse order as a proper sentence.
 ************************************************************************************ */
public class HiFour {
	public static void main (String[] args){
		String hi = "Hi "+args[3]+", "+args[2]+", "
				+args[1]+", and "+args[0]+".";
		System.out.println(hi);
	}
}
