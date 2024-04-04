class Solution {
    public TreeNode constructBST(int[] preorder, int start, int end){
        if(start > end || start >= preorder.length) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int rightindex = split(preorder,start,end, preorder[start]);
        root.left = constructBST(preorder, start+1, rightindex-1);
        root.right = constructBST(preorder,rightindex, end);
        return root;
    }
    public int split(int[] preorder, int start, int end,int root){
        int left = start+1;
        int right = end+1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(preorder[mid]>root)
            right = mid;
            else
            left=mid+1;
        }
        return left;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder,0,preorder.length-1);
    }
}
