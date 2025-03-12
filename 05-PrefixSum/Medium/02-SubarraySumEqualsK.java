Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

// Brute force Method 
  
        int count = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
// iterate through the array and find the range of subarray whose sum == k 

// Optimal Soln (Prefix Sum + Map)

class Solution {
    public int subarraySum(int[] nums, int k) {
       
        HashMap<Integer, Integer> map = new HashMap<>(); // Create a HashMap to store prefix sums and their frequencies.
        map.put(0, 1); // Initialize the map with prefix sum 0, occurring once (empty subarray)
        int n = nums.length;
        int count = 0;
        int prefixsum = 0;
      
        // Iterate through the input array.
        for (int i = 0; i < n; i++) {
            prefixsum += nums[i];// Update the prefix sum by adding the current element.
            
            // Calculate the required prefix sum 'x' such that prefixsum - x = k, or x = prefixsum - k.
            int x = prefixsum - k;
            
            // Check if 'x' exists in the map.
            if (map.containsKey(x)) {
                count += map.get(x); // If 'x' exists, increment the count by the frequency of 'x'.
            }
            // Update the frequency of the current prefix sum in the map.
            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        }
        // Return the count of subarrays with sum k.
        return count;
    }
}

Logic Explanation:

The core idea is to use a HashMap to store the prefix sums encountered so far and their frequencies. 
For each element, we calculate the current prefix sum. Then, we check if there exists a previous prefix sum
x such that prefixsum - x = k. If such an x exists, it means that the subarray between the index of x and the 
current index has a sum of k. The frequency of x in the map indicates how many such subarrays exist.
We add this frequency to the count. Finally, we update the frequency of the current prefix sum in the map.

Time Complexity:
O(n): The code iterates through the input array once.

Space Complexity:
O(n): In the worst case, the HashMap might store all prefix sums, which can be up to n distinct values.
