// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// if every number is equal to the desiredsum/number of elements -> we get threshold
// but numbers less than threshold will not contribute equal number
// we need to add extra contribution from numbers less than init to remaining numbers by increasing threshold
// add (exceess need)/remaining number of elments to threshold after sorting array

public class ArrayThreshold {
    public static double findThreshold(double[] nums, double desiredSum) {

        int n = nums.length;
        double init = desiredSum / n;
        Arrays.sort(nums);

        for (int i = 0; i < n - 1; i++) {
            if (init <= nums[i])
                break;
            init += (init - nums[i]) / (n - i - 1);
        }

        return init;
    }
}