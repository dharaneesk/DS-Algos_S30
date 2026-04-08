// Time Complexity : O(n) number of brackets
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// the first tax beacket would be 0 - bracket 0 and next bracket 0 - b1 and so on
// tax the particular bracket till the income become zero
// at the end of the iteration taxable would become the rest of the income

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int lower = 0;
        double result = 0;
        int i = 0;

        while (income > 0) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            int taxable = Math.min(income, upper - lower);
            result += taxable * percent / 100.0;
            lower = upper;
            i++;
            income -= taxable;
        }

        return result;
    }
}