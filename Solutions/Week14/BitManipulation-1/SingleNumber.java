// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// xor of 2 same numbers is 0 (same bits cancel each other out)
// xor all numbers -> same numbers cancel each other with unique number remaining
// xor num ^ 0 = num

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums)
            result ^= num;
        return result;
    }
}