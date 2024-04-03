class Solution {
    public boolean solve(TreeNode root, int k, Set<Integer> set){
        if(root==null) return false;

        if(set.contains(k-root.val))
        return true;

        set.add(root.val);
        return(solve(root.left,k,set)|| solve(root.right,k,set));
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return solve(root,k,set);
    }
}
