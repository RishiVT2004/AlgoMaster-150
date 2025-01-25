You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. 
However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
  
1.] Greedy Solution
The problem is essentially about finding opportunities to make as much profit as possible by buying stocks on one day and selling them on another. 
This can be achieved by making transactions whenever there's a profit to be made, without concern for a future decrement in prices.

Intuition:
In a simplified manner, the problem reduces to accumulating all positive differences between consecutive days. 
By always projecting into the future and accumulating possible gains daily, we capitalize on every rising curve of the stock price graph.

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for(int i = 0;i<n-1;i++){
            int j = i+1;
            if(prices[i] < prices[j]){
                profit += (prices[j] - prices[i]);
            }
        }
        return profit;
    }
}

O(N) time and O(1) space
