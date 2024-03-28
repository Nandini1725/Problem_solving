class Solution {
    public int countpath(TreeNode root, int targetSum){
        if(root==null)
        return 0;

        int path=0;

        if(root!=null && root.val==targetSum){
            path++;
        }
        

        path+= countpath(root.left, targetSum-root.val);
        path+= countpath(root.right, targetSum-root.val);
        return path;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int rootpath = countpath(root, targetSum);
        int leftpath=0;
        int rightpath=0;
        if(root.left!=null){
            leftpath = pathSum(root.left, targetSum); 
        }
        if(root.right!=null){
            rightpath = pathSum(root.right, targetSum);
        } 
        return rootpath + leftpath + rightpath;
    }
}
