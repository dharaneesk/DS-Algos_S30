// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// we find the number of left shift of divisor required to cross dividend
// and if the remainder is greater than divisor -> means more minimal shifts required
// update the divident to the remainder and keep repeating the process

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        int result = 0;
        while (ldividend >= ldivisor) {
            int shifts = 0;
            while (ldividend >= (ldivisor << (shifts + 1)))
                shifts++;
            result += (1 << shifts);
            ldividend -= (ldivisor << shifts);
        }

        if (dividend < 0 && divisor > 0)
            return -result;
        if (dividend > 0 && divisor < 0)
            return -result;
        return result;
    }
}