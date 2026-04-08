// Time Complexity : O(1) maximum 9 digit processing
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// trim the string and check if the first character should be a digit, + or - else return 0
// keep seperate variable for negative sign and check in the end ; do normal integer building
// LIMIT determines where the addition of new char variable can be done - if it causes overflow - return min/max respectively 

class Solution {
    public int myAtoi(String s) {
        int result = 0;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        char first = s.charAt(0);
        if (!Character.isDigit(first) && first != '+' && first != '-')
            return 0;

        boolean neg = false;
        if (first == '-')
            neg = true;

        int limit = Integer.MAX_VALUE / 10;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (neg) {
                    if (result > limit)
                        return Integer.MIN_VALUE;
                    else if (result == limit) {
                        if ((c - '0') >= 8)
                            return Integer.MIN_VALUE;
                    }
                } else {
                    if (result > limit)
                        return Integer.MAX_VALUE;
                    else if (result == limit) {
                        if ((c - '0') > 7)
                            return Integer.MAX_VALUE;
                    }
                }

                result = result * 10 + (c - '0');
            } else if (i != 0)
                break;
        }

        if (neg)
            return -result;
        return result;

    }

}