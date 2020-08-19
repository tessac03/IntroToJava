/* *************************************************************************************
 * Description: Takes an integer N and simulates a ring buffer with capacity N. 
 * Contains methods to get the capacity of the  ring buffer, the number of items in it,
 * to check if the ring buffer is full or empty, to add and remove an item from the
 * buffer, and to get the first item in the buffer.
 ************************************************************************************ */
public class RingBuffer {
	private double [] ringBuffer;
	private int first;
	private int last;
	private int size;
	
    //Creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity){
    	first=0;
    	last=0;
    	size=0;
    	ringBuffer=new double[capacity];
    	
    }
   
    //Returns the capacity of this ring buffer
    public int capacity(){
    	return ringBuffer.length;
    }
    
	
    //Returns the number of items currently in this ring buffer
    public int size() {
    	return size;
    }
   
    //Is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
    	return (size==0);
    }
   
    //Is this ring buffer full (size equals capacity)?
    public boolean isFull(){
    	return (size==capacity());
    }
   
    //Adds item x to the end of this ring buffer
    public void enqueue(double x){
    	if(isFull()){
    		throw new RuntimeException("Ring Buffer is full");
    	}
    	
    	ringBuffer[last]=x;
    	last++;
    	size++;
    	
    	if(last>=capacity()){
    		last=0;
    	}
    }
   
    //Deletes and returns the item at the front of this ring buffer
    public double dequeue(){
    	if(isEmpty()){
    		throw new RuntimeException("Ring Buffer is empty");
    	}
    	
    	double temp=ringBuffer[first];
    	
    	first++;
    	size--;
    	
    	if(first>=capacity()){
    		first=0;
    	}
    	
    	return temp;
    	
    }
   
    //Returns the item at the front of this ring buffer
    public double peek() {
    	if(isEmpty()){
    		throw new RuntimeException("Ring Buffer is empty");
    	}
    	
    	return ringBuffer[first];
    }
   
    //Tests this class by directly calling all instance method
    /*public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) {
          buffer.enqueue(i);
          System.out.println(buffer.peek());
        }
        double t = buffer.dequeue();
        System.out.println(t);
        buffer.enqueue(t);
        System.out.println(buffer.peek());
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
          double x = buffer.dequeue();
          double y = buffer.dequeue();
          System.out.println(x+"+"+y);
          buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());
    }*/
}
