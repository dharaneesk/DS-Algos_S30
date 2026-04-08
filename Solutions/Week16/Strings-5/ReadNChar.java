// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Keep reading characters till n characters or read4 returns less than 4 char
// once you get characters from read4, append it to the buf for read and update the index
// while appending to read buf, check for idx < n

public class Solution extends Reader4 {
    /**
     * Reads up to n characters from the file using read4 API.
     *
     * @param buf Destination buffer to store the characters read
     * @param n   Maximum number of characters to read
     * @return The actual number of characters read
     */

    char[] buffer = new char[4];

    public int read(char[] buf, int n) {

        int idx = 0;
        int charRead = 4;
        while (idx < n && charRead == 4) {
            charRead = read4(buffer);
            for (int i = 0; i < charRead && idx < n; i++) {
                buf[idx++] = buffer[i];
            }
        }

        return idx;
    }
}