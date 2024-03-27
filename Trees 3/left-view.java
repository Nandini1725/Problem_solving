class Solution {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root==null) return list;
        q.add(root);
        while(!q.isEmpty()){
            list.add(q.peek().val);
            for(int i=q.size();i>0;i--){
                TreeNode node = q.remove();
                if(node.left!=null)
                q.add(node.left);

                if(node.right!=null)
                q.add(node.right);
            }
        }
        return list;
    }
}
