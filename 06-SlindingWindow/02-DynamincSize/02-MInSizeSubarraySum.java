Given an array of positive integers nums and a positive integer target, 
return the minimal length of a subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2

Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

// Brute Force Approach (O(N^2))

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    res = Math.min(res, j - i + 1);
                    break; // No need to check further for this i
                }
            }
        }
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}


// Optimal Soln

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0; // tracks rightmost element 
        int j = 0; // tracks leftmost element 

        int sum = 0;
        int res = Integer.MAX_VALUE; // tracks min len of valid subarray 

        while(j < n){ // continue untill j < n 
            sum += nums[j]; // add new element to sum

            while(sum >= target){ // while the curr sum > target 
                sum -= nums[i]; // reduce leftmost sum 
                res = Math.min(res,j-i+1); // update the min len 
                i++; // shrink the window 
            }
            j++; // increase the window 
        }

        if(res == Integer.MAX_VALUE){
            return 0; // for no valid subarray found ;
        }
        return res;
    }
}

The time complexity of your sliding window approach is O(n).

Explanation:
  
1.The while (j < n) loop runs at most n times because j moves from 0 to n - 1.

2.The inner while (sum >= target) loop moves i forward, but each element is processed at most once 
(since i also moves from 0 to n - 1 in total).

3.Since both pointers (i and j) traverse the array only once, the total number of operations is at most 2n,
which simplifies to O(n).
