class TreeNode{
    public TreeNode links[];
    public int count;

    public TreeNode(){
        this.links = new TreeNode[2];
        this.count=0;
    }
}

class Trie{
    public TreeNode root;

    public Trie(){
        this.root = new TreeNode();
    }

    public void insert(int num){
        TreeNode node = this.root;
        for(int i=31;i>=0;i--){
            int bit = (num >> i) & 1;
            if(node.links[bit]==null)
            node.links[bit] = new TreeNode();

            node = node.links[bit];
        }
        node.count++;
    }

    public int countTriplets(int num){
        TreeNode node = this.root;
        int count=0;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            if(bit==1){
                if(node.links[0] != null)
                count+=node.links[0].count;
            } else{
                if(node.links[1]!=null)
                count+=node.links[1].count;
            }
            node = node.links[bit];
        }
        return count;
    }
}
class Solution {
    public int countTriplets(int[] arr) {
        Trie trie = new Trie();
        for(int num : arr){
            trie.insert(num);
        }
        int count=0;
        for(int num : arr){
           count+= trie.countTriplets(num); 
        }
        return count;
    }
}
