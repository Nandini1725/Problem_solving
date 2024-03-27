class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root==null) return list;
        q.add(root);
        while(!q.isEmpty()){
            
            for(int i=q.size();i>0;i--){
                if(i==1)
                list.add(q.peek().val);
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
