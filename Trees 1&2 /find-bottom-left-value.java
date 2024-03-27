class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        int ans =0;
        q.add(root);
        while(!q.isEmpty()){
            ans = q.peek().val;
            for(int i=q.size();i>0;i--){
                TreeNode node = q.poll();

                if(node.left!=null)
                q.add(node.left);

                if(node.right!=null)
                q.add(node.right);
            }
        }
        return ans;
    }
}
