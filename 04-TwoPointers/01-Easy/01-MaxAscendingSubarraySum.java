Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.
A subarray is defined as a contiguous sequence of numbers in an array.
A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.

Example 1:
Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.

class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int curr = nums[0]; // tracks beginning of new contigious subarray with max sum 
        int max = 0;

        if(n==1) return curr;

        for(int i = 0;i<n-1;i++){
            int j = i+1;
            if(nums[i] < nums[j]){
                curr += nums[j];
            }else{
                max = Math.max(curr,max);
                curr = nums[j]; // beginning of new subarray 
            }
        }
        max = Math.max(curr,max);
        return max;

    }
}

O(N) Time + O(1) Space
