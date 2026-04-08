// TC: O(n)
// SC: O(1) at most both HashMap and set has 26 elements
// Approach: A key value pair for each char in string s (key) and its corresponding value in string t (value). check if the mapping is present. Have a seperate HashSet to get values in O(1). Use Hashset to eliminate duplicate values in string t.

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) return false;

        HashMap<Character, Character> sMap = new HashMap();
        HashSet<Character> tValues = new HashSet();

        for(int i=0;i<s.length();i++){
            if(sMap.containsKey(s.charAt(i))){
                if(sMap.get(s.charAt(i)) != t.charAt(i)) return false;
            } else{
                if(tValues.contains(t.charAt(i))) return false;
                sMap.put(s.charAt(i),t.charAt(i));
                tValues.add(t.charAt(i));
            }
        }

        return true;
    }
}