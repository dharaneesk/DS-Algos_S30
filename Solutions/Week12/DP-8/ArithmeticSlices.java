// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Start with 3 element and check if its a arimetic slice , add 1 if yes
// if the pattern continues add 1 more to the previous values possible values
// if pattern breaks reset to 0
// return the result of possible values at each index

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
                prev = prev + 1;
            else
                prev = 0;

            result += prev;
        }
        return result;
    }
}