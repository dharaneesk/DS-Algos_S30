// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// sum of product of subsets can be writen as [a,b,c]
//  (a+b+c+ab+ac+bc+abc) => (1+a)(1+b)(1+c) -1

public class SumOfProductOfSubsets {
    private static int sumOfProductofSubSets(int[] arr) {
        int result = 1;

        for (int a : arr)
            result *= (1 + a);

        return result - 1;
    }
}
