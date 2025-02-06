Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:

Input: nums = [2,2,1]

Output: 1

Approach 1 : HashMap (O(N) time + O(N) Space)

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        if(n == 1) return nums[0];

        for(int i = 0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        int res = 0;

        for(int x: map.keySet()){
            if(map.get(x) == 1){
                res = x;
                return res;
            }
        }
        return res;
    }
}

Optimal Approach (Using XOR) -> (O(N) Time + O(1) Space)

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int n : nums){
            res = res ^ n;
        }
        return res;
    }
}
concept : 
xor : 
0	0	: 0
0	1	: 1
1	0	: 1
1	1	: 0

for any 2 same no , their binary reprn are same hence their xor is same 
hence if n = (4^4)^2^2^3
           =  0^(2^2)^3
           =  0^0^3
           =  0^3
XOR of 0 with any no n gives us n 
          = 3

hence if we xor all no in array then the resultant will be the unique number 
