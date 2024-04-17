class Solution {

    public void dfs(int i, ArrayList<ArrayList<Integer>> adjList, int[] visited){
        visited[i]=1;
        for(Integer it : adjList.get(i)){
            if(visited[it]==0)
            dfs(it, adjList, visited);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int visited[] = new int[isConnected.length];
        int cnt=0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                cnt++;
                dfs(i,adjList,visited);
            }
        }
        return cnt;
    }
}
