package org.example.slidingwindows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubString {

    public static void main(String args[]) {

        String s = "abcdbea";

      int n =   findLongestSubString(s);
      System.out.println(n);


    }

    private static int findLongestSubString(String str) {

        int windowStart = 0;
        int longest = 0 ;
        int windowLenght =0;
        int i = 0;

        Map<Character,Integer> lastSeenAt = new HashMap<>();
    for(i = 0; i < str.length();i++) {


        if(!lastSeenAt.containsKey(str.charAt(i))) {
            lastSeenAt.put(str.charAt(i),i);
        }
        else {

            //This means we have seen the character already
            if(lastSeenAt.get(str.charAt(i)) >=windowStart) {

               windowLenght = i - windowStart;
              if(longest < windowLenght){
                  longest = windowLenght;
              }
                windowStart = lastSeenAt.get(str.charAt(i)) + 1;
            }


            lastSeenAt.replace(str.charAt(i),i);




        }

}

        if(longest < i-windowStart) {
            longest = i-windowStart;
        }

        return longest;

    }
  // NOT A GOOD SOLTION USE the algo monster template


    private static int findLongestSubStringEasy(String str) {

        int n = str.length();
        int longest = 0,r=0,l=0;
        Set<Character> window = new HashSet<>();


            while(r < n) {
                if(!window.contains(str.charAt(r))) {
                    window.add(str.charAt(r));
                    r++;
                }
                else {
                    window.remove(str.charAt(r));
                    l++;
                }
               longest = Math.max(longest,r-l);



            }

           return longest;




    }



}

