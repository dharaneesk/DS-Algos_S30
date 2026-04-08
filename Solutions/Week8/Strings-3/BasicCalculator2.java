// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Maintain tail variable to undo previous changes 
// Process last item with lastSign again

class Solution {

    //O(1) space
    public int calculate(String s) {
        s = s.trim();

        int n = s.length();
        if(n == 0) return 0;
        char lastSign = '+';
        int curr = 0;
        int calc = 0;
        int tail = 0;

        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr *10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ')|| i == n-1){
                if (lastSign == '+') {
                    calc += curr;
                    tail = curr;
                } else if (lastSign == '-') {
                    calc -= curr;
                    tail = -curr;
                } else if (lastSign == '*') {
                    calc = calc - tail + curr*tail; 
                    tail = curr * tail;
                } else if (lastSign == '/') {
                    calc = calc - tail + tail/curr; 
                    tail = tail/curr;
                }
                curr = 0;
                lastSign = c;
            }
        }

        return calc;
    }
}