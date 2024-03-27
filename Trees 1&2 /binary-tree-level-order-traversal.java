class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root==null)
        return ans;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list = new LinkedList<>();
            for(int i=q.size(); i>0;i--){
                TreeNode node = q.remove();
                list.add(node.val);
                if(node.left!=null)
                q.add(node.left);

                if(node.right!=null)
                q.add(node.right);

                
            }
            ans.add(list);
        }
        return ans;
    }
}
