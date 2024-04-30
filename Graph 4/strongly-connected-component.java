class Solution
{
    public void dfs(int i, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
        visited[i]=1;
        for(int it : adj.get(i)){
            if(visited[it]==0)
            dfs(it,visited,adj,stack);
        }
        stack.push(i);
    }
    public void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adjacentList){
        visited[node]=1;
        for(int it: adjacentList.get(node)){
            if(visited[it]==0)
            dfs(it,visited,adjacentList);
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0)
            dfs(i,visited,adj,stack);
        }
        
        ArrayList<ArrayList<Integer>> adjacentList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjacentList.add(new ArrayList<>());
        }
        
        for(int i=0;i<V;i++){
            visited[i]=0;
            for(int it: adj.get(i)){
                adjacentList.get(it).add(i);
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            int node = stack.peek();
            stack.pop();
            if(visited[node]==0){
                ans++;
                dfs(node,visited,adjacentList);
            }
        }
        return ans;
    }
}
