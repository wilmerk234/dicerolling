package edu.guilford;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class DiceRolling {
    public static void main(String[] args) {
       // we need a random object when we roll dice 
       Random rand = new Random();
       // Lets also define how many dice we have and how many faces each die
       final int NDICE = 1000;
       final int NFACE = 100;
       // * final* means that the program cannot change value 
       // use that for constants, and use identifiers with all capital letters 
       // decalre and create amd array of dice values 
       int[]dieValues =new int [NDICE];


       // but now we want random value for each die ; use a counting loop 
       // this is another way of initializing values in array
       //using an algoritm
       int index = 0;
       while (index < NDICE){ // while index is an allowed value 
        dieValues[index]= rand.nextInt(NFACE)+1;
        index = index + 1 ;
       }
  
       // lets see the results using a java utility class Arrays 
       System.out.println(Arrays.toString(dieValues));

       // find the maximum value in the array 
       // set the max value to the first value in the array 
       int maxValue = dieValues[0];

       // loop over each element in the array 
       // if the value of the element is larger, then set the max value 
      // to that new larger value; use a for each loop 
      for (int value : dieValues){ //loop over each element and store in value 
        if (value> maxValue){
            maxValue = value;
        }

      }


     // when the loop is done, print out the result
     System.out.println("The maximum value is "+ maxValue);
    // build a histogram 
    final int NBINS = 10;

    // we need a count array with that number of bins 
    int[]count = new int[NBINS];
    // This worls well if NBINS evenly divides NFACES 
     int binSize = NFACE / NBINS;
    // use a for--each loop to look at each die value and assign it to
    // the appropriate bin 
    for (int value : dieValues){
     int bin = (value - 1 )/ binSize; // this is the bin the value goess in 
     // example: value = 83; (value -1 )= 82 ; 82 / 100 = 8 in java 
     count [bin]= count[bin]+1 ;// add 1 to the bin value belongs to
    }
    // print out the result 
    System.out.println("Histogram : "+ Arrays.toString(count));
 
    }
}