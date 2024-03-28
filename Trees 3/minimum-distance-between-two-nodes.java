class GfG {
    public Node lca(Node root, int a, int b){
        if( root==null || a==root.data || b==root.data)
        return root;
        
        Node left = lca(root.left,a,b);
        Node right = lca(root.right,a,b);
        
        if(left==null)
        return right;
        
        else if(right==null)
        return left;
        
        else
        return root;
    }
    int findDist(Node root, int a, int b) {
        Node lca = lca(root,a,b);
        return depth(lca,a)+depth(lca,b);
    }
    
    public int depth(Node lca, int num){
        if(lca==null)
        return -1;
        
        if(lca.data==num)
        return 0;
        
        int left = depth(lca.left,num);
        int right = depth(lca.right,num);
        
        if(left==-1 && right==-1)
        return -1;
        
        return 1+Math.max(left,right);
    }
}
