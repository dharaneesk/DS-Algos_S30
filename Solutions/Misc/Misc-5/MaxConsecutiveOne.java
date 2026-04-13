// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We maintain a window of size i - low +1 at every place
// if count of zeros becomes greater than k, we move low and maintain the previous max size achieved
// its like checking for max size window only and hoping count reduces and window becomes bigger
// at the end the n-low gives the maximum window size possible

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                count++;
            if (count > k) {
                if (nums[low] == 0)
                    count--;
                low++;
            }
        }

        return n - low;
    }
}