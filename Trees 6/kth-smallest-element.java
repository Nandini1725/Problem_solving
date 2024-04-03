class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        while(root!=null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            root = s.pop();
            k--;
            if(k==0)
            return root.val;

            root=root.right;

        }
        return 0;
    }
}
