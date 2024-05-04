class pair{
    int node;
    int distance;

    pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int dijkstra(int i,int n, int[][] edges, int distanceThreshold, ArrayList<ArrayList<pair>> adj){
        PriorityQueue<pair> pq = new PriorityQueue<pair>((x,y)-> x.distance - y.distance);
        int cnt=-1;
        boolean[] visited = new boolean[n];
        pq.offer(new pair(i,0));
        while(!pq.isEmpty()){
            pair p = pq.poll();
            int node = p.node;
            int distance = p.distance;
            if(visited[node]==true) continue;
            visited[node]=true;
            cnt++;
            for(pair it : adj.get(node)){
                int adjNode = it.node;
                int adjDis = it.distance;
                if(adjDis + distance <= distanceThreshold && visited[adjNode]==false){
                    pq.offer(new pair(adjNode,adjDis+distance));
                }
            }
        }
        return cnt;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]));
        }
        for(int i=0;i<n;i++){
            int cnt = dijkstra(i,n,edges,distanceThreshold,adj);
            if(min>cnt){
                min=cnt;
                ans = i;
            }
            else if(min==cnt){
                if(ans<i){
                    ans=i;
                }
            }
        }
        return ans;
    }
}
