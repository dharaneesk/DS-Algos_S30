
// https://leetcode.com/problems/basic-calculator/

class Solution {

    int i =0;
    public int calculate(String s) {
        s = s.trim();
        return evaluate(s);
    }

    public int evaluate(String s) {

        int curr = 0;
        int calc = 0; 
        char lastSign = '+';  
        Stack<Integer> st = new Stack();

        while(i<s.length()){
            char c = s.charAt(i++);
            if(Character.isDigit(c)){
                curr = curr *10 + c - '0';
            }

            if((!Character.isDigit(c) && c != ' ') || i == s.length()){
                if (c == '(') {
                    curr = evaluate(s);
                }

                if (lastSign == '+') {
                    st.push(curr);
                }
                else if (lastSign == '-') {
                    st.push(-1*curr);
                } 
                else if (lastSign == '*') {
                    st.push(st.pop()*curr);
                } else if (lastSign == '/') {
                    st.push(st.pop()/curr);
                }
                curr = 0;
                lastSign = c;

                if (c == ')') {
                    while(!st.isEmpty()) calc+= st.pop();
                    return calc;
                }
            }
        }

        while(!st.isEmpty()) calc+= st.pop();

        return calc;
    }
}