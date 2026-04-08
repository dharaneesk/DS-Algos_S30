// Time Complexity : O(n*k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// for finding atmost k transcation profit 
// -->> when a new transcation comes into picture, the prev best transcation becomes the single best transcation for the buy[i-1]
// introduce the net profit of i-th transcation in buy[i] using p-sell[i-1] ->> buy[i] becomes -ve and adds to the profit in sell[i]
// repeat the process for k transcations

class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, prices[0]);

        for (int p : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.min(buy[j], p - sell[j - 1]);
                sell[j] = Math.max(sell[j], p - buy[j]);
            }
        }

        return sell[k];
    }
}