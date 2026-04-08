// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We store 3 pointers and value variables for each of the factors 2,3,5
// change the pointer and precalculate the value of n if its the min value
// its like keeping a min heap of 3 numbers at every step and updating the values for next iteration

class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        arr[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Math.min(n2, Math.min(n3, n5));
            arr[i] = min;
            if (min == n2) {
                p2++;
                n2 = arr[p2] * 2;
            }
            if (min == n3) {
                p3++;
                n3 = arr[p3] * 3;
            }
            if (min == n5) {
                p5++;
                n5 = arr[p5] * 5;
            }
        }

        return arr[n - 1];
    }
}