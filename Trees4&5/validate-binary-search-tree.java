public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
  this.val = val;
  this.left = left;
  this.right = right;
  }
}
class Solution {
    public TreeNode visited;

    public boolean inorder(TreeNode root){
        if(root==null) return true;

        if(!inorder(root.left))
        return false;

        if(visited!=null && visited.val>=root.val)
        return false;

        visited=root;
        if(!inorder(root.right))
        return false;

        return true;
    }
    public boolean isValidBST(TreeNode root) {
        visited=null;
        return inorder(root);
    }
}
