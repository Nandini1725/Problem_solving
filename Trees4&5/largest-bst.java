class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int size;
    static int[] solve(Node root){
        if(root==null)
        return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        
        int[] leftTree = solve(root.left);
        int[] rightTree = solve(root.right);
        
        if(leftTree[1]<root.data && rightTree[0]>root.data){
            int x = leftTree[2]+rightTree[2]+1;
            size=Math.max(x,size);
            return new int[] {Math.min(leftTree[0],root.data),Math.max(rightTree[1],root.data),x};
        }
        
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE,0};
    }
    static int largestBst(Node root)
    {
        // Write your code here
        size=0;
        solve(root);
        return size;
        
    }
    
}
