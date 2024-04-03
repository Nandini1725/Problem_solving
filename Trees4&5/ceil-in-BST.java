class Tree {
    int ceil=-1;
    int findCeil(Node root, int key) {
        while(root!=null){
            if(root.data==key){
                ceil=root.data;
                return ceil;
            }
            if(key>root.data)
            root = root.right;
            
            else{
                ceil=root.data;
                root=root.left;
            }
        }
        return ceil;
    }
