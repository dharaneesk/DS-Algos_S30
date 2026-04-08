// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// bitmask1 returns us the value of a ^ b where a,b are 2 unique numbers
// we find the least significant bit by bitmask AND 2's complement of bitmask
// lsb AND a = 0 , lsb AND b != 0
// using this property we xor all the non zero lsb AND nums to get b
// now a = (a^b) ^ b

class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask1 = 0;
        for (int num : nums)
            bitmask1 ^= num;

        int lsb = bitmask1 & (-bitmask1);
        int bitmask2 = 0;

        for (int num : nums)
            if ((num & lsb) != 0)
                bitmask2 ^= num;

        return new int[] { bitmask2, bitmask2 ^ bitmask1 };
    }
}