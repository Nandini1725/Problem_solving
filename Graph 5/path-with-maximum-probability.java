class Pair{
    int node;
    double db;

    Pair(int node, double db){
        this.node = node;
        this.db = db;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); 
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }
        double[] dis = new double[n];
        dis[start_node]=1.0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.db, a.db));
        pq.offer(new Pair(start_node,1.0));
        while(!pq.isEmpty()){
            var it = pq.poll();
            double db = it.db;
            int node = it.node;

            for(var i: adj.get(node)){
                int adjNode = i.node;
                double adjdouble = i.db;
                if(db * adjdouble > dis[adjNode]){
                    dis[adjNode] = db * adjdouble;
                    pq.offer(new Pair(adjNode,dis[adjNode]));
                }
            }
        }
        return dis[end_node];
    }
}
