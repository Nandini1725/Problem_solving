public class Solution {
    public boolean solve(TreeNode A, List<Integer> list, int B){
        if(A==null)
        return false;
        
        list.add(A.val);
        
        if(A.val==B)
        return true;
        
        if(solve(A.left,list,B)|| solve(A.right,list,B))
        return true;
        
        list.remove(list.size()-1);
        return false;
    }
    public int[] solve(TreeNode A, int B) {
        List<Integer> list = new LinkedList<>();
        boolean ans = solve(A,list,B);
        int n =list.size();
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}
