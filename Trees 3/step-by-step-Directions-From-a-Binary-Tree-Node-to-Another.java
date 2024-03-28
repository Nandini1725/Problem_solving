class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        solve(lca(root,startValue,destValue),startValue,destValue, new StringBuilder());
        return "U".repeat(startPath.length()) + destPath;
    }

    public String startPath = " ";
    public String destPath = " ";

    public TreeNode lca(TreeNode root,int a,int b){
        if(root==null || root.val==a || root.val==b)
        return root;

        TreeNode left = lca(root.left,a,b);
        TreeNode right = lca(root.right,a,b);
        if(left==null)
        return right;

        else if(right==null)
        return left;

        else
        return root;
    }

    public void solve(TreeNode root,int p, int q, StringBuilder s){
        if(root == null) return;
        if(root.val == p)
        startPath=s.toString();
        if(root.val== q)
        destPath=s.toString();

        solve(root.left, p, q, s.append('L'));
        s.deleteCharAt(s.length()-1);
        solve(root.right, p, q, s.append('R'));
        s.deleteCharAt(s.length()-1);
    }
}
