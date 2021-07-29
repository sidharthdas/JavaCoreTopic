package JavaCoreTopicsImplementation17thJul2021.practice.leetcode;

/**
 * @author sidharthdas on 29/07/21.
 */
public class MainCalsas {

    public static void main ( String[] args ) {

    }


    public double angleClock(int hour, int minutes) {

       int val = minutes * 11 - hour * 60; //

       if(val <0){
           val = (-1) * val;
       }

       double angle = val /2;

       return angle;

    }
}
