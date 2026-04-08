//TC : O(n) -> length of the string s -> due to split function
//SC: O(1) -> key value would remain max 26 still
//Approach : Same as Isomorphic String, instead will have char key and String value pairs

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] sParts = s.split(" ");
        if(pattern.length() != sParts.length) return false;

        HashMap<Character, String> sMap = new HashMap();
        HashSet<String> values = new HashSet();

        for(int i=0;i<pattern.length();i++){
            if(sMap.containsKey(pattern.charAt(i))){
                if(!sMap.get(pattern.charAt(i)).equals(sParts[i])) return false;
            } else{
                if(values.contains(sParts[i])) return false;
                sMap.put(pattern.charAt(i),sParts[i]);
                values.add(sParts[i]);
            }
        }

        return true;
    }
}
