// Time Complexity : O(n)
// Space Complexity : O(h) for recursive stack dfs, O(n/2) for queue bfs since we are storing at most n/2 elements at the last level in List
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In the DFS approach, we use the recursion to note the level of each node and put the node vals in the corresponding list index.
// In the BFS approach, we put the nodes in a queue and take note of the size of the queue to process only the elements of each level. This is done using a  loop that iterates size times.

class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList();
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int level){
        if(root == null) return;

        if(result.size() <= level)
            result.add(new ArrayList());
        
        helper(root.left,level+1);
        result.get(level).add(root.val);
        helper(root.right,level+1);
        return;
    }

    public List<List<Integer>> levelOrderQueue(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;

        Queue<TreeNode> nodes = new LinkedList();
        nodes.add(root);

        while(!nodes.isEmpty()){
            List<Integer> level = new ArrayList();
            int size = nodes.size();
            TreeNode node;
            for(int i =0;i<size;i++){
                node = nodes.poll();
                if(node.left != null){
                    nodes.add(node.left);
                }
                if(node.right != null){
                    nodes.add(node.right);
                }
                level.add(node.val);
            }
            result.add(level);
        }

        return result;
    }
}