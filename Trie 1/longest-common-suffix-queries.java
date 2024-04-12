class TreeNode {
    TreeNode[] links = new TreeNode[26];
    int len = Integer.MAX_VALUE; 
    int index = Integer.MAX_VALUE; 

    boolean isnull(char ch) {
        return links[ch - 'a'] == null;
    }

    void put(char ch, TreeNode node) {
        links[ch - 'a'] = node;
    }

    TreeNode get(char ch) {
        return links[ch - 'a'];
    }

}

public class Trie {
    private static TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(int i, String s) {
        StringBuilder sb = new StringBuilder(s);
        String word = sb.reverse().toString();
        TreeNode node = root;
        int n = word.length();
        for (int j = 0; j < n; j++) { 
            char ch = word.charAt(j);
            if (node.isnull(ch)) {
                node.put(ch, new TreeNode());
            }
            node = node.get(ch);
            if (node.len > n) {
                node.len = n;
                node.index = i;
            } else if (node.len == n && node.index > i) {
                node.index = i;
            }
        }
    }

    public int queryWordContainer(String s) {
        StringBuilder sb = new StringBuilder(s);
        String word = sb.reverse().toString();
        TreeNode node = root;
        int ans = node.index; 
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.isnull(ch)) {
                break;
            }
            node = node.get(ch);
            ans = node.index; 
        }
        return ans;
    }
}

class Solution {
    private static Trie trie;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        trie = new Trie();
        int[] ans = new int[wordsQuery.length];
        int n = wordsContainer.length;
        int m = wordsQuery.length;

        for (int i = 0; i < n; i++) {
            trie.insert(i, wordsContainer[i]);
        }

        for (int i = 0; i < m; i++) {
            ans[i] = trie.queryWordContainer(wordsQuery[i]);
        }

        int smallestLengthIndex = 0;
        int smallestLength = Integer.MAX_VALUE;
        for (int i = 0; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < smallestLength) {
                smallestLength = wordsContainer[i].length();
                smallestLengthIndex = i;
            } else if (wordsContainer[i].length() == smallestLength && i < smallestLengthIndex) {
                smallestLengthIndex = i;
            }
        }
        
        for(int i =0;i<ans.length;i++){
            if(ans[i] == Integer.MAX_VALUE){
                ans[i] = smallestLengthIndex;
            } 
        }

       return ans ;
    }

}
