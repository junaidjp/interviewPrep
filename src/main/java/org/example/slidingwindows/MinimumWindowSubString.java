package org.example.slidingwindows;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {


    public static void main(String[] args) {
        // String[] s = {"PATTERN", "LIFE", "ABRACADABRA", "STRIKER", "DFFDFDFVD"};
        // String[] t = {"TN", "I", "ABC", "RK", "VDD"};


        String[] s = {"PATTERN",};
        String[] t = {"TN",};
        for (int i = 0; i < s.length; i++) {
            System.out.println((i + 1) + ".\ts: " + s[i] + "\n\tt: " + t[i] + "\n\tThe minimum substring containing " + t[i] + " is: " + minWindow(s[i], t[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static String minWindow(String s, String t) {

        if (t.equals("")) {
            return "";
        }
        Map<Character, Integer> reqCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        char[] charArrayForT = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {

            char ch = t.charAt(i);
            window.put(ch, 0);
            reqCount.put(ch, 1 + reqCount.getOrDefault(ch, 0));


        }


        int current = 0;
        int required = reqCount.size();

        int[] res = {-1, -1};

        int resLen = Integer.MAX_VALUE;


        int left = 0;
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);


            if (t.indexOf(ch) != -1) { //Means that T contains this character //Then add this frequency in Windows

                window.put(ch, 1 + window.getOrDefault(ch, 0));
            }

            //If the frequency of character in window is equal to the frequency of character in t , Increnet current
            if (reqCount.containsKey(ch) && reqCount.get(ch).equals(window.get(ch))) {
                current += 1;
            }

            while (current == required) {

                if ((right - left + 1) < resLen) {

                    res[0] = left;
                    res[1] = right;
                    resLen = (right - left + 1);


                }

                //Pop from the left of our window
                char leftChar = s.charAt(left);

                if (t.indexOf(leftChar) != -1) { // Means that the T contains this left char , Then decrease the frequency of this character in your window
                    window.put(leftChar, window.get(leftChar) - 1);
                }

                //If the popped character was among the required characters and the removing it has reduced the frequency belows its frequency in t, decrement current
                if (reqCount.containsKey(leftChar) && window.get(leftChar) < reqCount.get(leftChar)) {
                    current -= 1;
                }
                left += 1;

            }

        }
        int leftIdx = res[0];
        int rightIndex = res[1];

        return resLen != Integer.MAX_VALUE ? s.substring(leftIdx, rightIndex + 1) : "";

    }


    private static String minWindowPractice(String s, String t) {


        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> reqCount = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            window.put(ch, 0);
            reqCount.put(ch, 1 + reqCount.getOrDefault(ch, 0));
        }

        int left = 0;

        int current = 0;
        int required = reqCount.size();

        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            //If the current character also occurs in t
            if (t.indexOf(ch) != -1) {

                window.put(ch, 1 + window.getOrDefault(ch, 0));
            }


            //if Both the frewuency of the chracter in window and reqCount match then update current
            if (reqCount.containsKey(ch) && window.get(ch).equals(reqCount.get(ch))) {
                current += 1;
            }

            while (current == required) {


                if ((right - left) + 1 < resLen) {


                    res[0] = left;
                    res[1] = right;
                    resLen = right - left + 1;

                }

                //Now POP the left element

                char leftchar = s.charAt(left);


                if (t.indexOf(leftchar) != -1) {
                    // decrement  the frequency of this characterin window
                    window.put(leftchar, window.get(leftchar) - 1);

                }

                if (reqCount.containsKey(leftchar) && window.get(leftchar) < reqCount.get(leftchar)) {
                    current -= 1;
                }

                left += 1;
            }

        }

        int leftIndex = res[0];
        int rightIndex = res[1];
        return resLen != Integer.MAX_VALUE ? s.substring(leftIndex, rightIndex + 1) : "";

    }




    public static String minWindowpractice3(String s,String t) {

        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> reqCountMap = new HashMap<>();


        for(int i=0;i<t.length();i++) {
           char ch = t.charAt(i);
            reqCountMap.put(ch, 1 + reqCountMap.getOrDefault(ch,0));
            window.put(ch,0);


        }

        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE;
        int current =0;
        int required = reqCountMap.size();

        int left = 0;
        for(int right=0; right < s.length();right++) {

            char ch = s.charAt(right);
            if (t.indexOf(ch) != -1) { //If this character is present in t string then we update the window
                window.put(ch, 1 + window.getOrDefault(ch, 0));
            }

            //If both the frequency of window and


            if (reqCountMap.containsKey(ch) && window.get(ch).equals(reqCountMap.get(ch))) {
                current += 1;
            }


            while (current == required) {

                if ((right - left + 1) < resLen) {
                    res[0] = left;
                    res[1] = right;
                    resLen = right - left + 1;
                }


                char leftChar = s.charAt(left);
                if (t.indexOf(leftChar) != -1) {
                    window.put(leftChar, window.get(leftChar) - 1);
                }


                if (reqCountMap.containsKey(leftChar) && window.get(leftChar) < reqCountMap.get(leftChar)) {
                    current -= 1;

                }

                left += 1;

            }

        }

        int leftChar = res[0];
        int rightChar = res[1];
        return resLen != Integer.MAX_VALUE ? s.substring(leftChar,rightChar + 1) : "";


    }
}
