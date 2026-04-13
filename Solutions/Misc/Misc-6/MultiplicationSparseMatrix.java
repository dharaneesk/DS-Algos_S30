// Time Complexity : O(mn*common)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// mat1 = m*common , mat2 = common*n => result = m*n
// iterate every element in mat1 and add its contribution to the result array
// if any element is 0 , we can skip its contribution
// mat1(i,j) = contributes to every result(i,k) with mat2(j,k)

public class MultiplicationSparseMatrix {
    public int[][] multiply(int[][] mat1, int[][] mat2) {

        int m = mat1.length;
        int n = mat2[0].length;
        int common = mat1[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < common; j++) {
                if (mat1[i][j] == 0)
                    continue;

                for (int k = 0; k < n; k++) {
                    if (mat2[j][k] == 0)
                        continue;
                    result[i][k] += mat1[i][j] * mat2[j][k];
                }
            }
        }

        return result;
    }
}