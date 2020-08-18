/* *************************************************************************************
 * Description: Simulates encryption/description of an image (input type png) using 
 * class LFSR. Uses predefined class type Picture to process the image.
 ************************************************************************************ */
import java.awt.Color;

public class PhotoMagic {
    //returns a new picture that has a transformed copy of the given picture, 
	//using the given lfsr
    public static Picture transform(Picture picture, LFSR lfsr){
       int width =picture.width();
       int height=picture.height();
       
       for(int j=0; j<width; j++){
    	   for(int k=0; k<height; k++){
    		   Color color=picture.get(j,k);
    		   int red=color.getRed();
    		   int newR=lfsr.generate(8)^red;
    		   int green=color.getGreen();
    		   int newG=lfsr.generate(8)^green;
    		   int blue= color.getBlue();
    		   int newB=lfsr.generate(8)^blue;
    		   Color newcolor=new Color(newR, newG, newB);
    		   picture.set(j,k,newcolor);
    	   }
       }
       return picture;
    }

    // takes the name of an image file and a description of an lfsr as command-line arguments;
    // displays a copy of the image that is "encrypted" using the LFSR.
    public static void main(String[] args){
    	Picture picture1 = new Picture(args[0]);
    	LFSR lfsr = new LFSR("01101000010100010000", 17);
        Picture res = transform(picture1, lfsr);
    	res.show();
    }	
}
