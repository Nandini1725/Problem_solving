class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        solve(root, new StringBuilder(), ans);
        return ans;
    }
    public void solve(TreeNode root, StringBuilder s, List<String> ans){
        if(root==null) return;
        int n = s.length();
        if(n>0)
        s.append("->");

        s.append(root.val);
        if(root.left==null && root.right==null){
            ans.add(s.toString());
        }
        else{
            solve(root.left,s,ans);
            solve(root.right,s,ans);
        }
        s.setLength(n);
    }
}
