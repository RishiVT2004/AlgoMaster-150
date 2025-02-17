Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
Example 1:
Input: nums = [1,1,1], k = 2
Output: 2
  
Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

Brute Force Soln (O(N^2) time)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i : nums){
            if(i == k){
                count++;
            }
        }
        int n = nums.length;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(countSum(nums,i,j,k)){
                    count++;
                }else{
                    continue;
                }
            }
        }
        return count;
    }

    private boolean countSum(int[] nums,int i,int j,int k){
        int sum = 0;
        for(int x = i;x<=j;x++){
            sum += nums[x];
        }
        return sum == k;
    } 
}
