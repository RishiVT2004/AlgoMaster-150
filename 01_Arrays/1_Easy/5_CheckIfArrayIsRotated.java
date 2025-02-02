Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length],
where % is the modulo operation.

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length; // Store the length of the input array nums.

        int count = 0; // Initialize a counter to track the number of times the order is "broken" (i.e., nums[i] > nums[i+1]).

        // Iterate through the array from the beginning to the end.
        for (int i = 0; i < n; i++) {
            // Check if the current element is greater than the next element.
            // The (i + 1) % n handles the wrap-around for the last element, effectively comparing it with the first element.
            if (nums[i] > nums[(i + 1) % n]) {
                count++; // If the order is broken, increment the counter.
            }
        }

        // A rotated sorted array can have at most one "break" in the order.
        // If the count is less than or equal to 1, it means the array is potentially a rotated sorted array.  Return true.
        // Otherwise, if the count is greater than 1, it means the array is not a rotated sorted array. Return false.
        return count <= 1; 
    }
}
