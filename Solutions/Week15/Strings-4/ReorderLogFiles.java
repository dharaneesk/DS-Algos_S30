// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Comparator for (a,b) if a positive value is return it brings b before a
// Comparator for (a,b) if a negative value is return it keeps a before b
// Comparator for (a,b) if a 0 value is return it keeps the original order

// break down logs into 2 parts, leave as it is if both are digits (return 0)
// if a is dig and b is let - brring b before a - return positive
// if a is let and b is dig - keep a and b as it is - return negative
// if both are let - compare second part of let - if same compare first part

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] log1 = a.split(" ", 2);
            String[] log2 = b.split(" ", 2);
            boolean isDig1 = Character.isDigit(log1[1].charAt(0));
            boolean isDig2 = Character.isDigit(log2[1].charAt(0));

            if (!isDig1 && !isDig2) {
                int comp = log1[1].compareTo(log2[1]);
                if (comp == 0)
                    return log1[0].compareTo(log2[0]);
                return comp;
            } else if (isDig1 && !isDig2) {
                return 1;
            } else if (!isDig1 && isDig2) {
                return -1;
            } else
                return 0;
        });
        return logs;
    }
}