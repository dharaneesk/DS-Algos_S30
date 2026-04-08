// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// The number that is going to match completly will be top[0] or bottom[0]
//  if there are only 2 numbers, the min will be the same anyways
// increment up movement by 1 if top is not matching and down movement by 1 to match bottom for each target top[0] and bottom[0]

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int re = check(tops, bottoms, tops[0]);
        if (re != -1)
            return re;
        re = check(tops, bottoms, bottoms[0]);
        return re;
    }

    private int check(int[] tops, int[] bottoms, int target) {
        int up = 0;
        int down = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target)
                return -1;
            if (tops[i] != target)
                up++;
            if (bottoms[i] != target)
                down++;
        }

        return Math.min(up, down);
    }
}