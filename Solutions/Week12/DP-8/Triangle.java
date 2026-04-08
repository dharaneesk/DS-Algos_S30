// Time Complexity : O(n^2)
// Space Complexity : O(n) // O(1) if we can mutate the input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We calculate the minimum path sum from the bottom to the top
// At each step we choose the minimum of 2 possible path i and i+1 below
// Iterate to the top and return the minimum value
// Can be done with DFS and memo dp with top down approach

class Solution {
    public int minimumTotalDFS(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        return dfs(triangle, 0, 0, dp);
    }

    private int dfs(List<List<Integer>> triangle, int r, int c, int[][] dp) {
        if (r == triangle.size() || c == triangle.size())
            return 0;

        if (dp[r][c] != Integer.MAX_VALUE)
            return dp[r][c];

        int left = dfs(triangle, r + 1, c, dp);
        int right = dfs(triangle, r + 1, c + 1, dp);

        return dp[r][c] = triangle.get(r).get(c) + Math.min(left, right);
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {

                int belowL = triangle.get(i + 1).get(j);
                int belowR = triangle.get(i + 1).get(j + 1);
                int min = triangle.get(i).get(j) +
                        Math.min(belowL, belowR);

                triangle.get(i).set(j, min);
            }
        }

        return triangle.get(0).get(0);
    }

}