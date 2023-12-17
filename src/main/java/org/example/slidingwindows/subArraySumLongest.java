package org.example.slidingwindows;

public class subArraySumLongest {

    public static void main(String args[]) {



        int[] nums = {1, 6, 3, 1, 2, 4, 5};
        int target = 10;

        int longest = subArraySumLongest(nums,target);
        System.out.println(longest);



    }


    public static int subArraySumLongest(int[] nums,int target) {

        int left =0;
        int n = nums.length;
        int lenght = 0;
        int sum =0;
        for(int right=0; right < nums.length;right++) {

        sum+=nums[right];
        while(sum < target) {
            sum = sum - nums[left];
            left++;
        }
        lenght = Math.max(lenght,right-left+1);
        }







        return 0;

    }


    public static int subArraySumLongestPractice(int[] nums,int target) {
        int length =0;
        int windowsum =0 ;
        int left = 0 ;
        int longest =  0 ;

        for(int right = 0 ; right < nums.length; right++ ) {

            windowsum = windowsum + nums[right];


            while(windowsum > target) {


                //Remove the character from window and slide it
                windowsum = windowsum - nums[left];
                left++;
            }
            longest = Math.max(longest, right - left + 1);

        }



      return 0;

    }







}
