Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.


Method 1 : Sorting method 

import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) { // Handle empty or null input
            return 0;
        }

        Arrays.sort(nums); // Sort the input array in ascending order.  This is crucial for finding consecutive elements.

        int n = nums.length; // Store the length of the array for easier use.
        int maxCount = 0; // Initialize the maximum consecutive sequence length to 0.
        int currentCount = 1; // Initialize the current consecutive sequence length to 1 (as a single element is a sequence itself).

        for (int i = 0; i < n - 1; i++) { // Iterate through the sorted array, stopping one element before the end.
            if (nums[i + 1] == nums[i] + 1) { // Check if the next element is consecutive (exactly one greater than the current).
                currentCount++; // If consecutive, increment the current count.
            } else if (nums[i + 1] == nums[i]) { // Handle duplicates:  Consecutive but same value.
                continue; // Skip duplicates; they don't break the sequence or add to the count.
            } else { // If the next element is not consecutive, the current sequence ends.
                maxCount = Math.max(maxCount, currentCount); // Update maxCount if the current sequence is longer.
                currentCount = 1; // Reset currentCount to 1 for the new potential sequence.
            }
        }

        // After the loop, update maxCount one last time in case the longest sequence extends to the very end of the array.
        maxCount = Math.max(maxCount, currentCount);

        return maxCount; // Return the length of the longest consecutive sequence found.
    }
}

Method 2 : Hashing 

  import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;

    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
        numSet.add(num);
    }

    int longestStreak = 0;

    for (int num : numSet) {
        // Check if num is the beginning of a sequence
        if (!numSet.contains(num - 1)) {
            int currentNum = num;
            int currentStreak = 1;

            // Increment currentNum to count the length of sequence
            while (numSet.contains(currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }
    }
    return longestStreak;
    }
}
