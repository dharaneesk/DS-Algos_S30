// Time Complexity : O(l)
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We store the Trie in reverse order to find suffix from the character stream
// to optimise on the space, we delete the string builder first index to keep it at max word length
// Iterate through the stringbuilder and check if at any point we have a string start and return if found

class StreamChecker {

    class TrieNode {
        TrieNode[] children;
        boolean isStart;

        TrieNode() {
            children = new TrieNode[26];
            isStart = false;
        }
    }

    private void insert(String word) {
        TrieNode curr = root;
        max = Math.max(max, word.length());
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }

        curr.isStart = true;
    }

    TrieNode root;
    StringBuilder sb;
    int max;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        for (String w : words)
            insert(w);
        sb = new StringBuilder();
    }

    public boolean query(char letter) {
        if (sb.length() > max) {
            sb.deleteCharAt(0);
        }
        sb.append(letter);
        TrieNode curr = root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
            if (curr.isStart)
                return true;
        }

        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */