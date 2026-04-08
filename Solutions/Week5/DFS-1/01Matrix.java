// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Update all the ones to -1. Add all the zeroes to the queue. Using BFS we find the level 1 elements that are adjacent to zeroes, we put them in the queue and update the distance as current level + 1.
// Similarly add the neighbours of level 1 and update as 2 and so on.

class Solution {

    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                else
                    mat[i][j] = -1;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] dir:this.dirs){
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1){
                    mat[nr][nc] = mat[cur[0]][cur[1]]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }

        return mat;
    }
}