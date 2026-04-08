// Time Complexity : O(N)
// Space Complexity : O(H) for dfs, O(N) for bfs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using BFS, Find the level order traversal of the tree and keep track of the rightmost element at each level. 
// Using DFS, we can traverse right-root-left through the tree and every new level encountered results in the rightmost element of that level.

class Solution {

    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList();
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int level){
        if(root == null) return;

        if(result.size()<=level) result.add(root.val);
        helper(root.right,level+1);
        helper(root.left,level+1);

        return;
    }

    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(i == size -1)
                    result.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }

        return result;
    }
}