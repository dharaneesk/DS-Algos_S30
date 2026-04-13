// Time Complexity : O(n)
// Space Complexity :   O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// at each level - calculate the extra coins - -ve need coins, +ve have extra
// it tells the movement of coins through the node - 3 extra coins - 3 moves needed to distribute
// calculate the abs value of extra at each node and add it to the result

class Solution {
    int moves;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int extra = root.val - 1;
        extra += dfs(root.left);
        extra += dfs(root.right);

        moves += Math.abs(extra);
        return extra;
    }
}