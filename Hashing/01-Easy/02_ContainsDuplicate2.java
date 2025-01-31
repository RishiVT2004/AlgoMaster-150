Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

1. Brute Force Soln (O(N^2) time and O(1) space)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int x = 0;
        int y = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(nums[i] == nums[j] && i!=j){
                    x = i;
                    y = j;
                    if(checkRes(x,y,k)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean checkRes(int x,int y,int k){
        return Math.abs(x-y) <= k;
    }
}

2. Optimal Soln(O(N) time + O(N) space)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        // HashMap to store the last index of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = nums[i]; // Current number

            // Check if the current number already exists in the map
            if (map.containsKey(x) && map.get(x) != i) {
                // Check if the absolute difference between indices is within k
                if (Math.abs(map.get(x) - i) <= k) {
                    return true; // Duplicate found within range
                }
            }

            // Update the current index of the number in the map
            map.put(x, i);
        }

        // No nearby duplicates found
        return false;
    }
}
Example

nums = [1, 2, 3, 1], k = 3
Iteration Breakdown
Iteration	i	    nums[i]	  mapbefore	       Check for Duplicate	                                        Update map
1	        0	      1	      {}	                    No	                                                    {1: 0}
2	        1	      2	      {1: 0}	                No	                                                  {1: 0, 2: 1}
3	        2	      3	      {1: 0, 2: 1}	          No	                                              {1: 0, 2: 1, 3: 2}
4	        3	      1	      {1: 0, 2: 1, 3: 2}	    Yes(index difference is 3 - 0 = 3, which is ≤ k)	    Return true
