public class Solution {
    public int maxDistance;
    public int maxNode;
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int distance, int[] visited){
        if(visited[node] == 1){
            return;
        }
        visited[node] = 1;
        if(distance>maxDistance){
            maxDistance = distance;
            maxNode = node;
        }
        for(int i = 0; i<adjList.get(node).size(); i++){
            dfs(adjList.get(node).get(i), adjList, distance+1, visited);
        }
    }
    public int solve(int[] A) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<A.length; i++){
            adjList.add(new ArrayList<>());
        }
        int root = -1;
        for(int i = 0; i<A.length; i++){
            if(A[i] == -1){
                root = i;
            }else{
                adjList.get(i).add(A[i]);
                adjList.get(A[i]).add(i);
            }
        }
        maxDistance=-1;
        maxNode = -1;
        int[] visited = new int[A.length];
        dfs(root, adjList, 0, visited);
        Arrays.fill(visited, 0);
        dfs(maxNode, adjList, 0, visited);
        return maxDistance;
    }
}
