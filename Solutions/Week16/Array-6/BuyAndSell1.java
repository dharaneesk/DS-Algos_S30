// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// update min buy price when you encounter a new low
// at every other index calculate the profit formed by having the min buy price

class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i])
                buy = prices[i];
            else
                profit = Math.max(profit, prices[i] - buy);
        }

        return profit;
    }
}