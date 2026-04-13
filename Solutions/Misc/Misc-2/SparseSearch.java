// Time Complexity : O(wlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Using binary search we search through the sorted array
// in case of empty string, to wide sweep to find the first string in left and right direction
// if found update mid as that string and continue with binary search

public class SparseSearch {
    private static int sparseSearch(String[] arr, String x, int n) {
        int l = 0;
        int h = arr.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            // Move mid to nearest non-empty string
            if (arr[mid].equals("")) {
                int left = mid - 1;
                int right = mid + 1;

                while (true) {
                    if (left < l && right > h) {
                        return -1;
                    } else if (left >= l && !arr[left].equals("")) {
                        mid = left;
                        break;
                    } else if (right <= h && !arr[right].equals("")) {
                        mid = right;
                        break;
                    }

                    left--;
                    right++;
                }
            }

            if (arr[mid].equals(x)) {
                return mid;
            } else if (x.compareTo(arr[mid]) < 0) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}