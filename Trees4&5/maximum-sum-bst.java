class Solution {
    public int sum;

    public int[] solve(TreeNode root){
        if(root==null)
        return new int[] {1,Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        
        int[] leftTree = solve(root.left);
        int[] rightTree = solve(root.right);

        if(leftTree[0]==1 && rightTree[0]==1 && leftTree[2]<root.val && rightTree[1]>root.val){
            int x = root.val+leftTree[3]+rightTree[3];
            sum= Math.max(sum,x);
            return new int[] {1, Math.min(leftTree[1],root.val),Math.max(rightTree[2],root.val),x};
        }

        return new int[4];
    }
    public int maxSumBST(TreeNode root) {
        solve(root);
        return sum;
    }

}
