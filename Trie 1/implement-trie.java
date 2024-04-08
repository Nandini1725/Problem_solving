class TreeNode{
    TreeNode links[] = new TreeNode[26];
    boolean flag = false;
    
    boolean isnull(char ch){
        return(links[ch-'a']==null);
    }
    void put(char ch, TreeNode node){
        links[ch-'a']=node;
    }

    TreeNode get(char ch){
        return links[ch-'a'];
    }

    boolean isEnd(){
        return flag;
    }

    void setEnd(){
        flag=true;
    }
}

class Trie {
    private TreeNode root;
    public Trie() {
        root = new TreeNode();
    }
    
    public void insert(String word) {
        TreeNode node= root;
        for(int i=0;i<word.length();i++){
            if(node.isnull(word.charAt(i))){
                node.put(word.charAt(i),new TreeNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TreeNode node = root;
        for(int i=0;i<word.length();i++){
            if(node.isnull(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for(int i=0;i<prefix.length();i++){
            if(node.isnull(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
