Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3]


class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        for(int i = 1 ; i < nums.length;i++){
            nums[i] += nums[i-1];
        }
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        if(left == 0){
            return nums[right];
        }
        return nums[right] - nums[left-1];
    }
}

eg : 
n1 = [1,2,3,4,5]
left,right = 2,4
prefix sum = [1,3,6,10,15]
ans = 2 + 3 + 4 = 9 
nums[right] = 10
nums[left] = 3
nums[left-1] = 1
ans = nums[right] - nums[left-1]

* 
n2 = [0,1,2,3]
l,r = 1,3
ans = 6 (0 + 1 + 2 + 3)
nums[r] = 3

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
