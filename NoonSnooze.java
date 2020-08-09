/* *************************************************************************************
 * Description: Takes an integer command line argument snooze and prints out the time
 * of day it will be snooze many minutes after 12:00pm.
 * Assumes that the input is a non-negative integer.
 ************************************************************************************ */

public class NoonSnooze {
    public static void main(String args[]){
        //Convert input from string to integer 
        //and define variables for computing number of hours and minutes
        int snooze=Integer.parseInt(args[0]);
        int mins, hours;
        
        //Compute number of hours and minutes from input
        mins=snooze%60;
        hours=snooze/60;
        
        //Properly format minutes into a string
        String min=Integer.toString(mins);
        if(mins<10){
            min = "0"+min;
        }
        
        //Compute whether it's am or pm
        int  hour = 12+hours;
        String ampm;
        if((hour%24)<12){
            ampm="am";
        }else ampm="pm";
        //Compute the hour after snooze
        if(hour==24||hour==12){
            hour=12;
        }else hour=hour%12;
        
        //Print out the time
        System.out.println(hour+":"+min+ampm);
    }
}
