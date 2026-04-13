// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Maintain a pair stack of char and its count
// when a new char is encoutered, we check if the prev char is same 
// if same - increase count and if count reaches k pop char, or push new cnt
// in case of new char push (char,1) pair
// the remaining stack is in reverse, return the reverse of the string

class Solution {
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Character> charSt = new ArrayDeque<>();
        ArrayDeque<Integer> cntSt = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!charSt.isEmpty() && curr == charSt.peek()) {
                int cnt = cntSt.pop();
                cnt++;

                if (cnt == k)
                    charSt.pop();
                else
                    cntSt.push(cnt);
            } else {
                charSt.push(curr);
                cntSt.push(1);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!charSt.isEmpty()) {
            char pop = charSt.pop();
            int cnt = cntSt.pop();
            for (int i = 0; i < cnt; i++)
                sb.append(pop);
        }

        return sb.reverse().toString();
    }
}