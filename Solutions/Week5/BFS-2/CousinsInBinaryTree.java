// Time Complexity : O(N)
// Space Complexity : O(H) for dfs, O(n) for bfs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Iterate through all the nodes in the tree and find the level, parent of x and y. For x,y to be cousins , they must be at the same level but have different parents.
// Using DFS take level and parents of x and y as seperate variables. In BFS, we can use a level queue to keep track of the current level. For the different parents check, we can check the childs of curr before adding it to the queue.

class Solution {

    TreeNode xp;
    TreeNode yp;
    int xd; int yd;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,0,x,y);
        return xp!=yp && xd==yd;
    }

    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        if(root == null) return;
        
        if(root.val == x){
            xd = level;
            xp = parent;
        }
        if(root.val == y){
            yd = level;
            yp = parent;
        }
        dfs(root.left,root,level+1,x,y);
        dfs(root.right,root,level+1,x,y);

        return;
    }
    
    public boolean isCousinsBFS(TreeNode root, int x, int y) {
        if(root == null) return false;

        boolean xfound = false;
        boolean yfound = false;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val == x) xfound = true;
                if(curr.val == y) yfound = true;

                if(curr.left !=null){
                    q.add(curr.left);
                }
                if(curr.right !=null){
                    q.add(curr.right);
                }
                if(curr.left !=null && curr.right !=null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
            }

            if(xfound && yfound) return true;
            if(xfound || yfound) return false;
        }

        return false;
    }
}