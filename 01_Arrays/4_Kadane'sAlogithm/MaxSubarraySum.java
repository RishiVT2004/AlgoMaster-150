Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

// Approach 1 - : 2 nested for loops -> O(N^2) time , TLE Excedded 
       
        int n = arr.length;
        int maxsum = Integer.MIN_VALUE;

        if(n == 1){
            return arr[0];
        }
        for(int i = 0;i<n;i++){
            int currsum = 0;
            for(int j = i;j<n;j++){
                currsum += arr[j];
                maxsum = Math.max(currsum,maxsum);
            }
        }

        return maxsum;

// Optimal Soln KADANE'S ALGORITHM

class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        
        // Initialize maxSum with the first element of the array
        int maxSum = arr[0]; 
        
        // Initialize currSum with the first element as well
        int currSum = arr[0];

        // If the array has only one element, return that element as the max sum
        if (n == 1) {
            return arr[0];
        }

        // Iterate through the array starting from the second element
        for (int i = 1; i < n; i++) {
            // Decide whether to include the previous sum or start fresh from the current element
            currSum = Math.max(arr[i], currSum + arr[i]);

            // Update maxSum if the current sum is greater
            maxSum = Math.max(currSum, maxSum);
        }

        // Return the maximum sum found
        return maxSum;
    }
}

Time Complexity
O(N) → The algorithm processes each element once.
Space Complexity
O(1) → Only a few variables are used.

Logic of the for Loop
  
1.Choice Between Starting Fresh or Extending the Subarray

  currSum = Math.max(arr[i], currSum + arr[i]);

  This checks whether the maximum sum subarray ending at index i should:
  Start fresh from arr[i] (if currSum + arr[i] becomes negative, starting fresh is better).
  Extend the existing subarray by adding arr[i] to currSum.

2.Updating maxSum

  maxSum = Math.max(currSum, maxSum);

  This keeps track of the highest sum encountered so far.
