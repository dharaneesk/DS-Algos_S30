// Time Complexity : O(1) -> max 4 iterations
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Maintain list of default values;
// Process elements below 20, tens and thousands seperatly

class Solution {

    private final String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {

        if(num == 0) return "Zero";

        int tmp = num;
        String result = "";
        int i =0;

        while (tmp > 0) {
            int triplet = tmp %1000;
            if(triplet != 0)
                result = helper(triplet).trim() + " " + thousands[i] + " " + result;
            tmp /= 1000;
            i++;
        }

        return result.trim();
    }

    private String helper(int num){

        if (num == 0) 
            return "";
        else if(num<20)
            return below20[num];
        else if(num<100)
            return tens[num/10] + " " + helper(num%10).trim();
        else
            return below20[num/100]+ " Hundred " + helper(num%100).trim();
    }
}