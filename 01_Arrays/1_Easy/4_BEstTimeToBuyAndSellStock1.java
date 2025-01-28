You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a ifferent day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
// Brute force approach 
  /* 
    Use 2 loops i and j and for each combination of prices[i] and prices[j] update the maxprof;
  */
// Optimal Soln 

  class Solution {
    public int maxProfit(int[] prices) {
        // Initialize the maximum profit to 0 
        int maxprof = 0; 
        // Initialize the minimum price encountered so far to the maximum possible integer value 
        int minprice = Integer.MAX_VALUE; 

        // Iterate through each price in the prices array
        for(int price : prices){
            // Update the minimum price if the current price is lower
            if(price < minprice){
                minprice = price; 
            }
            // Calculate the current profit by subtracting the minimum price from the current price
            int currprof = price - minprice; 
            // Update the maximum profit if the current profit is greater than the previous maximum
            if(currprof > maxprof){
                maxprof = currprof; 
            }
        }
        // Return the maximum profit obtained
        return maxprof; 
    }
}

O(N) Time and O(1) Space 
