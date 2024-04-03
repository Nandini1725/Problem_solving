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
    public TreeNode previous;
    public TreeNode first;
    public TreeNode second;

    public void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);
        if(previous!=null && previous.val>root.val){
            if(first==null){
               first = previous; 
            }
            second = root;
        }
        previous = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val=second.val;
        second.val=temp;
    }
}
