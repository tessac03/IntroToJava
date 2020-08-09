/* *************************************************************************************
 * Description: Takes the specified levels of red, green, and blue, for a color then
 *  converts these into cyan, magenta, yellow, and black format.
 ************************************************************************************ */

public class RGBtoCMYK {
	public static void main(String[] args){
		//create and initialize variables for rgb using the values input
		//in the command line argument
		double red, green, blue;
		red = Double.parseDouble(args[0]);
		green = Double.parseDouble(args[1]);
		blue = Double.parseDouble(args[2]);
		
		//create variables for white and the cmyk values then determine
		//what the value of white should be based on the rgb values
		double white, cyan, magenta, yellow, black;
		white=Math.max(red/255,green/255);
		white=Math.max(white, blue/255);
		
		//calculte the cmyk values using the value of white and the values
		//of the rgb input
		cyan=(white-(red/255))/white;
		magenta=(white-(green/255))/white;
		yellow=(white-(blue/255))/white;
		black=1-white;
		
		//Print out the initial values for the rgb format then print out 
		//the values for the cmyk format
		System.out.println("red     = "+args[0]+"\ngreen   = "+args[1]+
				"\nblue    = "+args[2]+"\ncyan    = "+cyan+
				"\nmagenta = "+magenta+"\nyellow  = "+yellow+
				"\nblack   = "+black);
	}
}
