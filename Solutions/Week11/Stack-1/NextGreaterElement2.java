// Time Complexity : O(4n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// We use a monotonically decreasing stack to find the next greater element
// If we find a greater element, we resolve all the elements in the stack that are smaller
// We iterate through the array twice to handle the circular nature of the array
// When we are iterating the array 2nd time, we do not push the already resolved elements into the stack

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> st = new ArrayDeque();
        st.push(0);

        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int pop = st.pop();
                result[pop] = nums[i % n];
            }
            if (i < n)
                st.push(i);
        }

        return result;
    }
}