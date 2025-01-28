Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

Initial Approach 
  
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int []rotate = new int[n];
        int j = 0;


        for(int i = k;i<n;i++){
            rotate[i] = nums[j];
            j++;
        }

        for(int i = 0;i<k;i++){
            rotate[i] = nums[j];
            j++;
        }

        for(int i = 0;i<n;i++){
            nums[i] = rotate[i];
        }
    }
}

Issue -> need to solve in O(1) space with no extra array 

Optimal Soln -> Reversing Array 3 times 

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length; 
        // Calculate the effective rotation count by taking modulo with array length
        k = k % n; 

        // 1. Reverse the entire array
        reverse(nums, 0, n - 1); 
        // 2. Reverse the first 'k' elements
        reverse(nums, 0, k - 1); 
        // 3. Reverse the remaining elements (from k to the end)
        reverse(nums, k, n - 1); 
    }

    void reverse(int[] a, int l, int r) {
        // In-place reversal of subarray from index 'l' to 'r'
        while (l < r) { 
            // Swap elements at indices 'l' and 'r'
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++; // Move left pointer to the right
            r--; // Move right pointer to the left
        }
    }
}  

O(N) Time and O(1) Space 

** why do we use k = k%n ** 

If k is greater than n, it means we are rotating the array more times than its length.
For example, rotating an array of 5 elements by 7 positions is equivalent to rotating it by 2 positions (7 % 5 = 2).
The modulo operator (%) calculates the remainder when k is divided by n.
This effectively brings the rotation count within the valid range (0 to n-1).
Example:

Array: [1, 2, 3, 4, 5]
Rotation: k = 7
k = k % n = 7 % 5 = 2
Now, we rotate the array by 2 positions. (similar to rotating array by 7 positions)
