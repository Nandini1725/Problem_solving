class Solution {
    public void solve(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> path){
        if(root==null) return;

        targetSum-=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null && targetSum==0){
            ans.add(new LinkedList<>(path));
        }
        solve(root.left, targetSum, ans,path);
        solve(root.right, targetSum,ans,path);

        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        solve(root,targetSum, ans, path);
        return ans;
    }
}
