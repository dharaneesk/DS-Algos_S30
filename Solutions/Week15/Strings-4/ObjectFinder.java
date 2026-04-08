// Time Complexity : O(logm + logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// While binary search check if the next movement we are taking is producing a hotter result before hand
// first find optimal row with fixed col , take mid and down to mid response - if hotter proceed down or up
// after finding row, do similarly for col with fixed row , 
// check if its the exact before returning result

enum Response {
    HOTTER, COLDER, SAME, EXACT;
}

public class ObjectFinder {

    private int prevRow = -1;
    private int prevCol = -1;

    private final int targetRow = 2;
    private final int targetCol = 2;

    public static void main(String[] args) {
        GFG finder = new GFG();
        int[][] grid = {
                { 'o', 'o', 'o' },
                { 'o', 'o', 'o' },
                { 'o', 'o', 'o' },
                { 'o', 'o', 'o' },
                { 'o', 'o', 'x' }
        };

        int[] ans = finder.findObject(grid);
        System.out.println("Object found at: [" + ans[0] + ", " + ans[1] + "]");
    }

    // TODO
    public int[] findObject(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        prevRow = -1;
        prevCol = -1;
        int row = binarySearchRow(m, 0);

        prevRow = -1;
        prevCol = -1;
        int col = binarySearchCol(row, n);

        if (getResponse(row, col) == Response.EXACT)
            return new int[] { row, col };
        return new int[] { -1, -1 };
    }

    private int binarySearchRow(int rows, int fixedCol) {
        int low = 0;
        int high = rows - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            Response midResponse = getResponse(mid, fixedCol);
            if (midResponse == Response.EXACT)
                return mid;

            Response downResponse = getResponse(mid + 1, fixedCol);
            if (downResponse == Response.EXACT)
                return mid + 1;

            if (downResponse == Response.HOTTER)
                low = mid + 1;
            else
                high = mid;
        }

        System.out.println("Row : " + low);
        return low;
    }

    private int binarySearchCol(int row, int cols) {
        int low = 0;
        int high = cols - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            Response midResponse = getResponse(row, mid);
            if (midResponse == Response.EXACT)
                return mid;

            Response rightResponse = getResponse(row, mid + 1);
            if (rightResponse == Response.EXACT)
                return mid + 1;

            if (rightResponse == Response.HOTTER)
                low = mid + 1;
            else
                high = mid;
        }

        System.out.println("Col : " + low);

        return low;
    }

    public Response getResponse(int r, int c) {
        if (r == targetRow && c == targetCol) {
            return Response.EXACT;
        }

        if (prevRow == -1 && prevCol == -1) {
            prevRow = r;
            prevCol = c;
            return Response.HOTTER;
        }

        int prevDist = Math.abs(prevRow - targetRow) + Math.abs(prevCol - targetCol);
        int newDist = Math.abs(r - targetRow) + Math.abs(c - targetCol);

        Response res;
        if (newDist == 0) {
            res = Response.EXACT;
        } else if (newDist < prevDist) {
            res = Response.HOTTER;
        } else if (newDist > prevDist) {
            res = Response.COLDER;
        } else {
            res = Response.SAME;
        }

        prevRow = r;
        prevCol = c;

        return res;
    }

}
