class Solution {
    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return res-1;
    }

    public int solve(TreeNode root){
        if(root==null)
        return 0;

        int l = solve(root.left);
        int r = solve(root.right);

        int temp = 1+Math.max(l,r);
        int ans = Math.max(temp,1+l+r);
        res = Math.max(res,ans);
        return temp;
    }
}
