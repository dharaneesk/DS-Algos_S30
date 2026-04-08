// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// If the robot after one step of instructions is facing north, it wont return to origin
// mime the execution using directions array of [N,E,S,W] (either clockwise or anti)
// R-goes i+1 and L goes i-1 , check if its facing north or have reached the origin 

class Solution {
    public boolean isRobotBounded(String instructions) {
        int n = instructions.length();

        int x = 0;
        int y = 0;
        int i = 0;
        int[][] dirs = new int[][] {
                { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
        };

        for (int ins = 0; ins < n; ins++) {
            char c = instructions.charAt(ins);
            if (c == 'G') {
                x += dirs[i][0];
                y += dirs[i][1];
            } else if (c == 'R')
                i = (i + 1) % 4;
            else if (c == 'L')
                i = (i + 3) % 4;
        }

        return (i != 0 || (x == 0 && y == 0));
    }
}