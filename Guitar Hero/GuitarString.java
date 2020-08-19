/* *************************************************************************************
 * Description: Takes a user specified frequency and Simulates a guitar string using 
 * the method RingBuffer.
 ************************************************************************************ */
public class GuitarString {
	private RingBuffer buffer;
	private double frequency;
	private double cap;
	private int samplingRate=44100;
	
	
	// creates a guitar string of the specified frequency, 
	// using a sampling rate of 44,100
    public GuitarString(double frequency){
    	cap=samplingRate/frequency;
    	int intCap=(int) Math.ceil(cap);
    	buffer=new RingBuffer(intCap);
    	for(int i=0;i<cap;i++){
    		buffer.enqueue(0);
    	}
    }
	  
	//Creates a guitar string whose length and initial values 
	//are given by the specified array
	public GuitarString(double[] init){
		int len=init.length;
		buffer=new RingBuffer(len);
		for(int i=0;i<len;i++){
			buffer.enqueue(init[i]);
		}
	}
	  
	//returns the number of samples in the ring buffer  
	public int length(){
		return buffer.size();
	}
	  
	//Plucks this guitar string (by replacing the ring buffer 
    // with white noise)           
	public void pluck(){
		for(int i=0;i<cap;i++){
			buffer.dequeue();
			buffer.enqueue(Math.random()-0.5);
		}
	}
	   
	//Advances the Karplus-Strong simulation one time step
	public void tic(){
		double first=buffer.peek();
		buffer.dequeue();
		double second=buffer.peek();
		double newFirst=0.994*0.5*(first+second);
		buffer.enqueue(newFirst);
	}

    //Returns the current sample          
	public double sample(){
		return buffer.peek();
	}
	
	//Tests this class by directly calling both constructors 
	//and all instance methods
	public static void main(String[] args) {
		   double[] samples={0.2, 0.4, 0.5, 0.3, -0.2, 0.4, 0.3, 0.0, -0.1, -0.3 };
		   GuitarString testString = new GuitarString(samples);
		   int m = 25; // 25 tics
		   for (int i = 0; i < m; i++) {
		      double sample = testString.sample();
		      System.out.printf("%6d %8.4f\n", i, sample);
		      testString.tic();
		   }
	}
}
