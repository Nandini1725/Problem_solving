import java.util.List;
import java.util.*;
import java.util.ArrayList;
 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }
public class Solution {

    public static List<Integer> list;
    public static boolean isleaf(TreeNode root){
        if(root.left==null && root.right==null)
        return true;

        return false;
    }

    public static void addleafnode(TreeNode root){
        if(isleaf(root)){
            list.add(root.data);
            return;
        }

        if(root.left!=null)
        addleafnode(root.left);

        if(root.right!=null)
        addleafnode(root.right);
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        list = new ArrayList<>();
        if(root==null)
        return list;

        if(!isleaf(root))
        list.add(root.data);

        TreeNode node = root.left;
        while(node!=null){
            if(!isleaf(node))
            list.add(node.data);

            if(node.left!=null)
            node=node.left;
            else
            node = node.right;
        }

        addleafnode(root);

        Stack<Integer> stack = new Stack<>();
        node = root.right;
        while(node!=null){
            if(!isleaf(node))
            stack.push(node.data);

            if(node.right!=null)
            node=node.right;
            else
            node=node.left;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }

        return list;
    }
}
