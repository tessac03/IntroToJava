/* *************************************************************************************
 * Description: Simulates a Linear-Feedback Shift Register with a specified seed and
 * tap. Contains a constructor for the class and methods to get the length of the seed, 
 * the bit in the seed at a specified index, to return the seed as a string, to 
 * simulate one step of the LFSR, to simulate a specified k steps of the LFSR.
 ************************************************************************************ */
public class LFSR {
    public int seed[];
    public int tap;

    //Constructor: creates an LFSR with the specified seed and tap
    public LFSR(String seedIn, int tapIn){ 
    	tap=tapIn;
    	seed=new int[seedIn.length()];
	    for(int j=seedIn.length()-1; j>=0; j--){
	    	seed[j]= Integer.parseInt(String.valueOf(seedIn.charAt(j)));
	    }
    }
	  
    //Returns the number of bits in the LFSR.
    public int length(){
		return seed.length; 	
    }

   //returns bit i as 0 or 1.
   public int bitAt(int i){
	   return seed[i];
   }

    //returns a string representation of this LFSR
    public String toString(){
    	String s="";
    	for(int j=0; j<length(); j++){
    		s+=seed[j];
    	}
    	return s;	
    }

    //simulates one step of this LFSR and return the new bit as 0 or 1
    public int step(){
    	int n = seed[0]^seed[length()-tap];

    	for(int j=0; j<length()-1; j++){
    	   seed[j]=seed[j+1];
    	}
    	seed[length()-1]=n;
    	
    	return n;
    }

    //simulates k steps of this LFSR and return the k bits as a k-bit integer
    public int generate(int k){
    	int temp=0;
    	
    	for(int i=0; i<k; i++){
    		 int n=step();
    	}
    	    	
    	for(int i=length()-1; i>(length()-1-k); i--){
    	    temp+=seed[i]*Math.pow(2, -1*(i-length()+1));
    	}
    	return temp;	
    }
}
