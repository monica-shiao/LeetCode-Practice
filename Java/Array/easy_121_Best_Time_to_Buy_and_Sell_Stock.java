/***
Tags: Array
Create: 2019/8/17
Update: 2019/8/21

Problem description:
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:
    Input: [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
                Not 7-1 = 6, as selling price needs to be larger than buying price.


Example 2:
    Input: [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.

***/

// Officail Version (Beautiful!)
// Runtime: 1 ms (faster than 88.85%); Memory Usage: 37.7 MB (less than 98.23%)

public class Solution {
    public int maxProfit(int prices[]) {
        int min = Integer.MAX_VALUE, max = 0;
        
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min)    min = prices[i];
            else if(prices[i] - min > max)    max = prices[i] - min;
        }
        
        return max;
    }
}


// My First Version (Brute Force)
// Runtime: 168 ms (faster than 14.19%); Memory Usage: 37.7 MB (less than 98.67%)

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, diff;
        
        // i is pointer
        for(int i = 0; i < prices.length - 1; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                diff = prices[j] - prices[i];
                if(diff > max)   max = diff;
            }
        }
        return max;
    }
}
