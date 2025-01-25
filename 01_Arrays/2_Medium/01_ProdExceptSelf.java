Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
// method 0 -> prod of arr / arr[i[
    public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int[] out = new int[n];
      int product_of_array_elements = 1;
      for(int i = 0;i<n;i++){
         product_of_array_elements *= nums[i];
      }
      for(int i = 0;i<n;i++){
          out[i] = product_of_array_elements/nums[i];
      }
      return out;
    }

reason this code dosent work -> 
  1. if an element is zero then we can't divide by 0 *** 
  2. prod_of_array_element can exceed given range 
// method 1 -> using  prefix and suffix arrays 
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] output = new int[n];

        prefix[0] = 1;

        for(int i = 1;i<n;i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }

        suffix[n-1] = 1;
        for(int i = n-2;i>=0;i--){
            suffix[i] = suffix[i+1]*nums[i+1];
        }

        for(int i = 0;i<n;i++){
            output[i] = prefix[i]*suffix[i];
        }
        return output;

issue -> uses extra space O(n) -> can be optimized 
  
// method 2 -> using single pass 

public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;
        for(int i = 1;i<n;i++){
            output[i] = output[i-1] * nums[i-1]; // calculates prod of element left of curr index
        }

        int rightproduct = 1; // keep tracks of product of element right of the curr index 
        for(int i = n-1 ; i>=0;i--){
            output[i] = output[i] * rightproduct;
            rightproduct = rightproduct * nums[i];
        }

        return output;
    }
/*
Example -> a = [1,2,3,4]
first we find the array of indexes with prefix product (product of all element left of index i)
a = [1,1,2,6] // prefix prod 

rightproduct is a variable that keeps track of the suffix product (product of all element right of index i) in the original array 
to get final array (prod except self) -> we need to nuliply each element of prefix array to adjecent right(suffix prod) value

while iterating from i = n-1 to i = 0 : 
n = 4
1. initially a = [1,1,2,6] and right = 1(initially -> suffix prod of index n-1) -> to be nultiplied to a[n-1]
2. new a = [1,1,2,6] , new right = right*num[i] = 1*4 = 4 (suffix prod of index n-2) -> to be multiplied to a[n-2]
3. new a = [1,1,8,6] , new right = right*num[i] = 4*3 = 12 -> to be multipled to index n-3
4. new a = [1,12,8,6] , new right = right*num[i] = 12*2 = 24 -> to me multiplpied to index n-4 (0)
5, new a = [24,12,8,6]

*/
