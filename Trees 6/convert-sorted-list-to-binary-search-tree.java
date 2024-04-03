class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for(ListNode i=head; i!=null; i = i.next){
            list.add(i.val);
        }
        return solve(0,list.size()-1,list);
    }
    public TreeNode solve(int left, int right,List<Integer> list){
        if(left>right) return null;

        int mid = (left+right)/2;
        TreeNode leftchild = solve(left,mid-1,list);
        TreeNode rightchild = solve(mid+1,right,list);
        TreeNode newNode = new TreeNode(list.get(mid),leftchild,rightchild);
        return newNode;
    }
}
