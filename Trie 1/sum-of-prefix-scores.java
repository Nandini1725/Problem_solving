class Trie{
    public Trie[] links = new Trie[26];
    public int count;

    public void insert(String word){
        Trie node = this;
        for(char ch : word.toCharArray()){
            if(node.links[ch-'a']==null)
            node.links[ch-'a']= new Trie();

            node = node.links[ch-'a'];
            node.count++;
        }
    }

    public int search(String word){
        Trie node = this;
        int sum=0;
        for(char ch: word.toCharArray()){
            if(node.links[ch-'a']==null)
            return 0;

            node=node.links[ch-'a'];
            sum+=node.count;
        }
        return sum;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for(String word : words)
        trie.insert(word);

        int[] ans = new int[words.length];
        for(int i=0;i<words.length;i++){
            ans[i] = trie.search(words[i]);
        }
        return ans;
    }
}
