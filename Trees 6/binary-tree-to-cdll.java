class Solution
{ 
    Node solve(Node left, Node right){
    if(left == null)
        return right;
        
    if(right == null)
        return left;
        
    Node leftend, rightend;
    leftend = left.left;
    rightend = right.left;
    
    leftend.right = right;
    right.left = leftend;
    
    left.left = rightend;
    rightend.right = left;
    
    return left;
}
    Node bTreeToClist(Node root)
    {
        if(root == null)
        return null;
        
        Node left, right;
    
        left = bTreeToClist(root.left);
        right = bTreeToClist(root.right);
        
        root.left = root;
        root.right = root;
        
        return solve(solve(left, root), right);
    }
    
}
