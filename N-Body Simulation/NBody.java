
import java.util.*;
import java.io.*;

public class NBody {
    public static void main(String[] args){
    //set two variables from command line arguments: duration of simulation
    //and simulation time increments
        double duration=Double.parseDouble(args[0]);
        double increments=Double.parseDouble(args[1]);
       
    //read in data from standard input with Scanner and store data as parallel arrays
    //first value is integer n the number of particles
    //second value is real number radius the radius of the universe
    //next n lines are each a particle with six values
        //1,2 are x,y-coordinates for particles initial position
        //3,4 are x,y-components of particles initial velocity
        //5 is the mass
        //6 is a string with the name of an image used to display the particle
    //remaining data describes the universe and should be ignored
        try{
        	System.out.print("Enter file name with extension: ");
            Scanner input=new Scanner(System.in);
            File file=new File(input.nextLine());
            input=new Scanner(file);
            
            int n=Integer.parseInt(input.nextLine());
            Double radius=Double.parseDouble(input.nextLine());
            
            double[]x=new double[n];
            double[]y=new double[n];
            double[]xvel=new double[n];
            double[]yvel=new double[n];
            double[]mass=new double[n];
            String[]image=new String[n];
            
            for(int j=0; j<n; j++){
                x[j]=Double.parseDouble(input.next());
                y[j]=Double.parseDouble(input.next());
                xvel[j]=Double.parseDouble(input.next());
                yvel[j]=Double.parseDouble(input.next());
                mass[j]=Double.parseDouble(input.next());
                image[j]=input.next();
                if(j==n-1) break;
                input.nextLine();
            }
            
            
            //Set the std draw output
            StdDraw.setXscale(-radius,radius);
            StdDraw.setYscale(-radius,radius);
            StdDraw.enableDoubleBuffering();
            
            double[]fx=new double[n];
            double[]fy=new double[n];
            double G=6.67e-11;
            
            //loop to calculate how the planets should move over the designated time frame
            //using the specified time intervals
            double time=0;
            while(time<duration){               	
            	//calculate force at time
            	for(int i=0; i<n; i++){
            		fx[i]=0;
            		fy[i]=0;
            		//Update the force on each planet at time 
            	    for(int j=0; j<n; j++){
            	    	if(i!=j){
            	    		
            	    		double dx=x[j]-x[i];
            	    		double dy=y[j]-y[i];
            	    		double d=Math.sqrt(dx*dx+dy*dy);
            	    		double F=(G*mass[i]*mass[j])/(d*d);
            	    		double Fx=(F*dx)/d;
            	    		double Fy=(F*dy)/d;
            	    		
            	    		fx[i]+=Fx;
            	    		fy[i]+=Fy;
            	    	}
            	    }
            	}
           
            	//calculate velocity at time        	
            	for(int i=0; i<n; i++){
            	    xvel[i]+=increments*(fx[i]/mass[i]);
            	    yvel[i]+=increments*(fy[i]/mass[i]);           	  
            	}
            	
            	//Calculate new position of the planets at time 
            	for(int i=0; i<n; i++){
            		x[i]+=increments*xvel[i];
            		y[i]+=increments*yvel[i];
            	}
            	
            	//Draw the output at time
            	StdDraw.picture(0, 0, "/Users/tessacotron/Documents/workspace/IntroCS/nbody/starfield.jpg");
            	for(int j=0; j<n; j++){
            		StdDraw.picture(x[j], y[j], "/Users/tessacotron/Documents/workspace/IntroCS/nbody/"+image[j]);
            	}
            	StdDraw.show();
            	StdDraw.pause(20);
            	time+=increments;
            }
        
            
            //print out final data for each planet 
            System.out.println(n);
            System.out.println(radius);
            for(int i=0; i<n; i++){
            	System.out.print(x[i]+"   "); 
             	System.out.print(y[i]+"   ");
               	System.out.print(xvel[i]+"   ");
               	System.out.print(yvel[i]+"   ");
               	System.out.print(mass[i]+"   ");
              	System.out.print(image[i]+"   ");
              	System.out.println();
            }
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
