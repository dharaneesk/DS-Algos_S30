// Time Complexity : O(sequence)
// Space Complexity : O(n) hash map of strings/hashindex
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Brute - for each 10 length substring , add to set and check for repeats
// to optimise space, check the incoming and outgoing char and update hashIndex acc
// subtring should include till i-9 from i => [0,10) - 10

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> result = new HashSet();
        HashSet<Long> hash = new HashSet();
        Map<Character, Integer> map = Map.of(
                'A', 1,
                'C', 2,
                'G', 3,
                'T', 4);

        Long h = 0l;
        Long l = (long) Math.pow(4, 9);
        for (int i = 0; i < n; i++) {
            if (i >= 10) {
                char out = s.charAt(i - 10);
                h -= l * map.get(out);
            }

            char in = s.charAt(i);
            h = h * 4 + map.get(in);

            if (i >= 9) {
                if (hash.contains(h)) {
                    result.add(s.substring(i - 9, i + 1));
                } else
                    hash.add(h);
            }
        }

        return new ArrayList<>(result);

    }

    public List<String> findRepeatedDnaSequencesBrute(String s) {
        int n = s.length();
        HashSet<String> result = new HashSet();
        HashSet<String> hash = new HashSet();

        for (int i = 0; i < n - 9; i++) {
            String str = s.substring(i, i + 10);
            if (hash.contains(str))
                result.add(str);
            else
                hash.add(str);
        }

        return new ArrayList<>(result);

    }
}