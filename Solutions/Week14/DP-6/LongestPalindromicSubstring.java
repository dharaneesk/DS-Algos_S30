// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We start at every index and expand left and right till its not a palindrome
// for odd length we start with i as middle element and for even length we start with i,i+1 as middle
// we can also solve using dp by having dp[i][j] which represents if substring(i,j+1) is a palindrome

class Solution {

    int max = 0;
    int start = 0;
    int end = 0;

    public String longestPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            extend(s, i, i);
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1))
                extend(s, i, i + 1);
        }

        return s.substring(start, end + 1);
    }

    private void extend(String s, int l, int r) {

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        l++;
        r--;
        if (r - l + 1 > max) {
            max = r - l + 1;
            start = l;
            end = r;
        }
    }

    public String longestPalindromeDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        int start = 0;
        int end = 0;

        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            dp[i][i] = true;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (i - j == 1 || dp[i - 1][j + 1]) {
                        dp[i][j] = true;
                        if (max < i - j + 1) {
                            max = i - j + 1;
                            start = j;
                            end = i;
                        }
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

}