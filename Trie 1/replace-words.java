class Trie{
    public Trie[] links = new Trie[26];
    public int storeindex = -1;

    public void insert(String word, int i){
        Trie node = this;
        for(char ch : word.toCharArray()){
            if(node.links[ch-'a']==null)
            node.links[ch-'a']= new Trie();

            node = node.links[ch-'a'];
        }

        node.storeindex = i;
    }
    public int search(String word){
        Trie node = this;
        for(char ch: word.toCharArray()){
            if(node.links[ch-'a']==null)
            return -1;

            node=node.links[ch-'a'];
            if(node.storeindex!=-1)
            return node.storeindex;
        }
        return -1;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(int i=0;i<dictionary.size();i++){
            trie.insert(dictionary.get(i),i);
        }

        String[] words = sentence.split("\\s+");
        List<String> list = new ArrayList<>();
        for(String word : words){
            int i = trie.search(word);
            if(i!=-1)
            list.add(dictionary.get(i));
            else
            list.add(word);
        }
        return String.join(" ", list);
    }
}
