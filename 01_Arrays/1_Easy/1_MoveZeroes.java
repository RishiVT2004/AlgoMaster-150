Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

1. Brute Force Method -> Using extra array of same size , fill it initially with all non zero element and remqaining with 0s

2. 2-pointers Method

class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int j = 0; // tracks latest index containing 0 
        for(int i = 0;i<len;i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }

        for(int i = j;i<len;i++){
            nums[i] = 0;
        }
    }
}
  
[0,1,0,3,12] ; i = 0 , j = 0 (skip)
[0,1,0,3,12] ; i = 1 , j = 0 (swap) => [1,0,0,3,12] (j++)
[1,0,0,3,12] ; i = 2 , j = 1 (skip)
[1,0,0,3,12] ; i = 3 , j = 1 (swap) => [1,3,0,0,12] (j++)
[1,3,0,0,12] ; i = 4 , j = 2 (swap) => [1,3,12,0,0] (j++)

new modified array -> [1,3,12,0,0]
