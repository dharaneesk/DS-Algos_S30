// Time Complexity : O(target -start)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// instead of doing start - target, go in reverse direction with /2 and +1
// this makes the solution a greedy path as we take only one step at each place
// divide only if its even and stop if the target becomes less than start
// add +1s to the remaining target -> start 

class Solution {
    public int brokenCalc(int startValue, int target) {
        int moves = 0;

        while (target > startValue) {
            if (target % 2 == 0)
                target /= 2;
            else
                target += 1;
            moves++;
        }

        return moves + startValue - target;
    }
}