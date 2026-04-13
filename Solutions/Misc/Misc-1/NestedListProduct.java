// Time Complexity : O(number of integers)
// Space Complexity : O(depth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// dfs into each nestedlist , if its a integer, multiply with depth, else dfs with depth+1
// we can also solve using multiple stacks - one for list and one for depth counter
// can solve using bfs , with levels at each size iteration

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // The result is undefined if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // The result is undefined if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class Solution {

    int result;

    public int depthSum(List<NestedInteger> nestedList) {
        result = 0;
        dfs(nestedList, 1);
        return result;
    }

    private void dfs(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger el : nestedList) {
            if (el.isInteger()) {
                result += depth * el.getInteger();
            } else {
                dfs(el, depth + 1);
            }
        }
    }
}