// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// for finding atmost 2 transcation profit -->> when a new transcation comes into picture, the prev transcation becomes the single best transcation before the buy
// introduce the net profit of 2nd transcation in buy2 using p-sell1 ->> buy2 becomes -ve and adds to the profit in sell2 
// 2,7,1,12 ->> at 1, buy2 becomes (1-5) =-4 to compensate for the -5 profit recorded earlier
// at 12 ->> sell2 becomes 12 - (-4) = 16 (2,7 = 5, 1,12 = 11)

class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = prices[0];
        int sell1 = 0;
        int buy2 = prices[0];
        int sell2 = 0;

        for (int p : prices) {
            buy1 = Math.min(buy1, p);
            sell1 = Math.max(sell1, p - buy1);
            buy2 = Math.min(buy2, p - sell1);
            sell2 = Math.max(sell2, p - buy2);
        }

        return sell2;
    }
}