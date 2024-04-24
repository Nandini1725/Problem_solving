class Solution {
    public void bfs(int i, List<List<Integer>> ancestor,int n, int[][] edges, List<List<Integer>> ans){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        boolean[] visited = new boolean[n];
        visited[i]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : ancestor.get(node)){
                if(visited[it]==false){
                    visited[it]=true;
                    q.add(it);
                    ans.get(it).add(i);
                }
            }
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ancestor= new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ancestor.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            ancestor.get(edge[0]).add(edge[1]);
        }
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            bfs(i,ancestor,n,edges,ans);
        }
        return ans;
    }

}
