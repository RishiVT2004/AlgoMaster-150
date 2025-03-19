class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxLen = 0;
        int currSum = 0;

        for(int i = 0;i<n;i++){
            if(nums[i] == 1){
                currSum+=1;
            }else{
                currSum-=1;
            }
            if(map.containsKey(currSum)){
                maxLen = Math.max(maxLen,i-map.get(currSum));
            }else{
                map.put(currSum,i);
            }
        }
        return maxLen;
    }
}
