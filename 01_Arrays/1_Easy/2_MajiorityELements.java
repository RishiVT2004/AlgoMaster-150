Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

'''''
  
  Logic 1 : Using Hashmap<>();
  -> count iteration of each nums and return key whose val(count) > n/2 [n-> len of arr] -> Uses Extra Space

  Logic 2 : Arrays.sort()
     public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2]; 
  }
  Time -> O(nlogn) // not most optimal time
  Majiority Element after sorting will always be present in the middle as it occurs the most time in an array 

  3.  Most Optimal Soln -> Moore's Voting Algorithm (Do not mug it up)

    public int majorityElement(int[] nums) {


  }
