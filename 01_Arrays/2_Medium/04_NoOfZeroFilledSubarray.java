Given an integer array nums, return the number of subarrays filled with 0.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,3,0,0,2,0,0,4]
Output: 6

Explanation: 
There are 4 occurrences of [0] as a subarray.
There are 2 occurrences of [0,0] as a subarray.
There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.

1. Brute Force Soln(O(N^2) time and O(1) space) 

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n && nums[j] == 0;j++){
                count++;
            }
        }
        return count;
    }
}

// j<n && nums[j] if this is not satisfied the inner loop breaks and dosent run 

The outer loop (for (int i = 0; i < n; i++)) starts at each index i and tries to form zero-filled subarrays by checking contiguous elements starting from i

Detailed Example
Input:
[1, 0, 0, 1, 0]

Outer loop starts at i = 0:

Inner loop doesn't run because nums[0] is 1.
Outer loop at i = 1:

Inner loop starts at j = 1:
nums[1] == 0, so count increases by 1 → count = 1
j = 2, nums[2] == 0, so count increases by 1 → count = 2
j = 3, nums[3] == 1, inner loop breaks.
Subarrays found: [0], [0, 0]

Outer loop at i = 2:

Inner loop starts at j = 2:
nums[2] == 0, so count increases by 1 → count = 3
j = 3, nums[3] == 1, inner loop breaks.
Subarray found: [0]

Outer loop at i = 3:

Inner loop doesn't run because nums[3] is 1.
Outer loop at i = 4:

Inner loop starts at j = 4:
nums[4] == 0, so count increases by 1 → count = 4
Subarray found: [0]


2. Optimal Soln (O(N) time + O(1) space)

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0; // tracks no of continious zeroes unitll a non zero element shows up
        long res = 0; // tracks total no of 0 subarrays 
        for(int n : nums){
            if(n == 0){
                count+=1; // inc count if a zero appears
            }else{
                count = 0; // reset count when the sequence od 0s are broken 
            }
            res += count; // after each iteration add the current count of 0s to res 
        }
        return res; 
    }
}
/*
 1 continious zero -> 1 subarray
 2 continious zero -> 3 subarrays 
 3 continious zero -> 6 subarrays

 n continious zero -> n*n-1/2 subarrays 
*/
Example Walkthrough
Let's break down the example input [1, 0, 0, 1, 0] step by step:

Step 1: n = 1

count = 0, res = 0
No zero found. Reset the count to 0.
Step 2: n = 0

count = 1, res = 1
One zero is found. One subarray [0].
Step 3: n = 0

count = 2, res = 3
Two consecutive zeros are found. Subarrays are [0], [0], [0, 0].
Step 4: n = 1

count = 0, res = 3
Non-zero encountered, reset the count.
Step 5: n = 0

count = 1, res = 4
One zero found. One subarray [0].
Final Result
The total number of zero-filled subarrays is 4.

