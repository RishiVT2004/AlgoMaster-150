You are given an integer array height of length n. There are n vertical lines drawn such that the 
two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;  // Get the number of elements in the height array
        int l = 0;  // Initialize the left pointer at the beginning of the array
        int r = n - 1;  // Initialize the right pointer at the end of the array
        int maxVol = 0;  // Variable to store the maximum water volume found
        
        // Use a two-pointer approach to find the maximum area
        while (l < r) {
            int h = Math.min(height[l], height[r]);  // Find the shorter height between left and right
            int w = r - l;  // Calculate the width of the container
            int currVol = h * w;  // Calculate the current water volume
            maxVol = Math.max(maxVol, currVol);  // Update maxVol if the current volume is greater
            
            // Move the pointer that has the smaller height to try and find a taller boundary
            if (height[l] > height[r]) {
                r--;  // Move the right pointer leftward
            } else {
                l++;  // Move the left pointer rightward
            }
        }
        
        return maxVol;  // Return the maximum volume found
    }
}
