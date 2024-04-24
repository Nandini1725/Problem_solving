class Solution {
    public boolean bfs(int[] visited, int i, int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        visited[i]=0;
        q.add(i);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it: graph[node]){
                if(visited[it]==-1){
                    if(visited[node]==1){
                        visited[it]=0;
                    }
                    else 
                    visited[it]=1;
                    q.add(it);
                }
                else if(visited[it]==visited[node])
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for(int i =0;i<visited.length;i++){
            visited[i]=-1;
        }

        for(int i=0;i<visited.length;i++){
            if(visited[i]==-1){
                if(!bfs(visited,i,graph))
                return false;
            }
        }
        return true;
    }
}
