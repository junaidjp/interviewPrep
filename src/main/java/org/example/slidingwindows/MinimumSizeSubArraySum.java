package org.example.slidingwindows;

public class MinimumSizeSubArraySum {

public  static void main(String args[]) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int smallestSubArray = subArraySumsmallest(nums,target);
        System.out.println(smallestSubArray);

    }

    private static int subArraySumsmallest(int[] nums, int target) {

    int smallest  = Integer.MAX_VALUE;
    int right = 0;
    int n = nums.length;
    int left = 0;
    int windowSum = 0;
   for( right=0; right < nums.length; right++) {
       windowSum = windowSum + nums[right];
       while(windowSum >= target) {
           smallest = Math.min(smallest,right-left+1);
           windowSum = windowSum - nums[left];
           left++;
       }

   }


     return smallest;



    }


}
