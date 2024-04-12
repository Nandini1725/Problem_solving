class TreeNode{
    TreeNode links[] = new TreeNode[2];

    boolean isnull(int i){
        return (links[i]==null);
    }
    TreeNode get(int i){
        return links[i];
    }
    void put(int i, TreeNode node){
        links[i]=node;
    }
}

class Trie{
    public static TreeNode root;
    Trie(){
        root = new TreeNode();
    }

    public static void insert(int num){
        TreeNode node = root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.isnull(bit))
            node.put(bit, new TreeNode());

            node = node.get(bit);
        }
    }

    public int ans(int num){
        TreeNode node = root;
        int maxnum = 0;
        for(int i=31;i>=0;i--){
            int bit = (num>>i) & 1;
            if(!node.isnull(1 - bit)){
                maxnum = maxnum | (1<<i);
                node = node.get(1-bit);
            }
            else
            node = node.get(bit);
        }
        return maxnum;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int i=0;i<nums.length;i++){
            trie.insert(nums[i]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,trie.ans(nums[i]));
        }
        return max;
    }
}
