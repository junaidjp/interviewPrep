package org.example.binarysearch;

import java.util.Arrays;

public class Bananas {

    public static void main(String args[]) {

        int[] piles = new int[] {3, 6, 7, 11};

        int hour = 8 ;

      int minimumSpeed =   minimumEatingSpeed(piles,hour);
      System.out.println("Minimum Speed required is " +minimumSpeed);



    }

    private static int minimumEatingSpeed(int[] piles, int hour) {
        // Minimum Speed is 1 banana per Hour
        int start = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        //Maximum speed is 11 bananas per hour

        // So the minimum speed number has to be between 1 and 11

        while (start < max) {

            //Get the mid
            int mid = start + (max - start) / 2;

            if (check(piles, mid, hour)) {
                // If valid continue to search
                // lower speed
                max = mid;

            }
            else {
                // If cant finish bananas in given
                // hours, then increase the speed
                start = mid +1;
            }


    }
       return max;
    }

    private static boolean check(int[] piles, int mid, int hour) {
        int total = 0;
        for (int pile : piles) {
            if (pile % mid != 0) { // Odd Number
                total += pile / mid + 1;
            } else { // Even
                total += pile / mid;
            }
        }
        if(total <= hour) {
            return true;
        }
        return false;
    }
}
