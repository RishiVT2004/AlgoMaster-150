You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the 
following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>(); // To store unique elements in the window
        int n = nums.length;
        long max = 0, currSum = 0;
        int left = 0; // Left pointer of the sliding window

        for (int i = 0; i < n; i++) {
            // If we encounter a duplicate, shrink the window from the left
            while (set.contains(nums[i])) {
                currSum -= nums[left]; // Remove the leftmost element from sum
                set.remove(nums[left]); // Remove from set
                left++; // Move left pointer to maintain uniqueness
            }

            // Add the current element to the set and update sum
            set.add(nums[i]);
            currSum += nums[i];

            // When the window size reaches k, check for max sum and slide the window
            if (i - left + 1 == k) {
                max = Math.max(max, currSum); // Update max sum
                currSum -= nums[left]; // Remove leftmost element from sum
                set.remove(nums[left]); // Remove from set
                left++; // Slide window forward
            }
        }

        return max;
    }
}

Time Complexity: O(N) – Each element is processed at most twice (added/removed).

Space Complexity: O(K) – The set stores at most k elements.
