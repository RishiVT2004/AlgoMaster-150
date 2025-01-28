// initial approach 

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i : nums){
            if(!list.contains(i)){
                list.add(i);
                count++;
            }else{
                continue;
            }
        }
        int x = list.size();

        for(int i = 0;i<x;i++){
            nums[i] = list.get(i);
        }
        return count;
    }
}

O(N) time + O(N) space
why i used arraylist and not hashset -: 
  This is because i had to retrieve element by indexes , and store it back it nums , retrieving based on index is not possible in hashset 
why is it so slow -: 
  The original solution is slow primarily due to the use of ArrayList.contains(). This method requires searching the entire list for each element, 
  resulting additional in O(n) time complexity whenever we try to search the list . 
  Additionally, creating and copying from an ArrayList adds unnecessary overhead.

  // Optimal (2 pointer approach)

  class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int i = 0; //-> keeps track of index of last unique element 
        
      //  *we start at j = 1 as the first index is already tracked by i , and we start comparision from the second index 
        
          for(int j = 1;j<n;j++){ 
            if(nums[i] != nums[j]){ // unique element detected
                i++; // inc index to represent new unique num 
                nums[i] = nums[j]; // substitute unique element in that place 
            }
        }
        /*
        to return -> len of array containing all unique element 
        i -> tracks last index containing a unique number 
        len of array containing all unique num -> i+1
        */
        return i+1;
    }
}


Time -> O(N)
Space -> O(1)
