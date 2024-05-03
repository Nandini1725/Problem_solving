class pair{
    int node;
    int distance;
    pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
class tuple{
    int stops;
    int node;
    int distance;
    tuple(int stops, int node, int distance){
        this.stops = stops;
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        } 
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new pair(flights[i][1], flights[i][2]));
        }
        int[] dist = new int[n];

        for(int i=0;i<n;i++){
            dist[i] = (int)(1e9);
        }
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0,src,0));
        while(!q.isEmpty()){
            tuple it = q.peek();
            int stops = it.stops;
            int node = it.node;
            int distance = it.distance;
            q.remove();
            if(stops>k) continue;
            for(pair i : adj.get(node)){
                int adjNode = i.node;
                int edgeW = i.distance;

                if(distance+edgeW < dist[adjNode] && stops<=k){
                    dist[adjNode]= distance+edgeW;
                    q.add(new tuple(stops+1 , adjNode, dist[adjNode]));
                }
            }
        }
        if(dist[dst]==(int)(1e9)) return -1;
        return dist[dst];
    }
}
