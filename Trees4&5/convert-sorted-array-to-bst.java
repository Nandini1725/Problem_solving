class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(0,nums.length-1,nums);
    }

    public TreeNode solve(int left, int right,int[] nums){
        if(left>right) return null;

        int mid = (left+right)/2;
        TreeNode leftchild = solve(left,mid-1,nums);
        TreeNode rightchild = solve(mid+1,right,nums);
        TreeNode newNode = new TreeNode(nums[mid],leftchild,rightchild);
        return newNode;
    }
}
