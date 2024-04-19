class Solution {
    public boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited){
        visited[i]=1;
        pathVisited[i]=1;
        
        for(int it : adj.get(i)){
            if(visited[it]==0){
                if(dfs(it, adj, visited, pathVisited)==true)
                return true;
            }
            else if(pathVisited[it]==1)
            return true;
        }
        
        pathVisited[i]=0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int visited[] = new int[V];
        int pathVisited[] = new int[V];
        
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(dfs(i,adj,visited,pathVisited))
                return true;
            }
        }
        return false;
    }
}
