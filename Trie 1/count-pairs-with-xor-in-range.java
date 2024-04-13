class TreeNode{
    public TreeNode links[];
    int cnt;
    TreeNode(){
        links=new TreeNode[2];
        cnt=0;
    }
    public void put(int bit){
        links[bit]=new TreeNode();
    }
    public TreeNode get(int bit){
        return links[bit];
    } 
    public boolean contains(int bit){
        return links[bit]!=null;
    }
    public void inc(int bit){
        links[bit].cnt++;
    }
}

class Trie{
    public TreeNode root;
    Trie(){
        root=new TreeNode();
    }
    public void insert(int x){
        TreeNode cur=root;
        for(int i=31;i>=0;i--){
            int bit=(x>>i)&1;
            if(!cur.contains(bit)){
                cur.put(bit);
            }
            cur.inc(bit);
            cur=cur.get(bit);
        }
    }
    public int maxXor(int x,int limit){
        int low_cnt=0;
        TreeNode cur=root;
        for(int i=31;i>=0 && cur!=null;i--){
            int bit=(x>>i)&(1);
            int req=(limit>>i)&1;
            if(req==1){
                if(cur.contains(bit)){
                    low_cnt+=cur.get(bit).cnt;
                }
                cur=cur.get(1-bit);
            }else{
                cur=cur.get(bit);
            }
            
        }
        return low_cnt;
        
    }
}
class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Trie trie=new Trie();
        int cnt=0;
        for(int i=nums.length-1;i>=0;i--){
            int count1=trie.maxXor(nums[i],low);
            int count2=trie.maxXor(nums[i],high+1);
            trie.insert(nums[i]);
            cnt+=count2-count1;
        }
        return cnt;
    }
}
