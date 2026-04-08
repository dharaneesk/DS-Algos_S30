// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// If the new color and the starting color are same, just return the original image. If they are different, start with the source and call dfs to the neighbouring edges with the original color only.
// change the color before calling the next neighbours so it does not end in infinite recursion.
// We can use the same using bfs, we start from the source node and add to the queue. we add same color nodes to the queue, change the color and expand similarly.

class Solution {

    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    int org;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc] == color) return image;
        dfs(image,sr,sc,color,m,n,image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int color, int m, int n,int org){
        if(i<0 || j<0 || i>=m || j>=n || image[i][j] != org) return;
        image[i][j] = color;
        for(int[] dir:dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(image, nr,nc,color,m,n,org);
        }
        return;
    }
}