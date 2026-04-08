// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// At every index, we have 4 choices (in buy phase - 0,1 and sell phase 0,1)
// if a buy is done, we add the profit inccured at sell[i-2] to the current buy
// if a sell is done , we check the sell at i-1 and buy at i-1 and sell at i
// this dp[i] can be reduced to 3 variables 
// where prevsell = sell[i-2], currBuy = buy[i-1], currSell = sell[i-1]

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;

        int prevSell = 0;
        int currBuy = Math.max(-prices[0], -prices[1]);
        int currSell = Math.max(prevSell, prices[1] + currBuy);

        for (int i = 2; i < n; i++) {
            int temp = currSell;
            currSell = Math.max(currSell, prices[i] + currBuy);
            currBuy = Math.max(currBuy, prevSell - prices[i]);
            prevSell = temp;
        }

        return currSell;
    }
}