class pair{
    int node;
    int distance;
    pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]));
        }
        PriorityQueue<pair> pq = new PriorityQueue<pair>((x,y) -> x.distance - y.distance);
        long[] frontArr = new long[n];
        long[] backArr = new long[n];
        for(int i=0;i<n;i++){
            frontArr[i] = Integer.MAX_VALUE;
            backArr[i] = Integer.MAX_VALUE;
        }
        frontArr[0]=0;
        backArr[n-1]=0;

        pq.offer(new pair(0,0));
        while(!pq.isEmpty()){
            pair p = pq.poll();
            int node = p.node;
            int distance = p.distance;
            for(pair it : adj.get((int)node)){
                int adjNode = it.node;
                int adjDis = it.distance;
                if(adjDis+distance < frontArr[adjNode]){
                    frontArr[adjNode]= adjDis+distance;
                    pq.offer(new pair(adjNode, adjDis+distance));
                }
            }
        }

        pq.offer(new pair(n-1,0));
        while(!pq.isEmpty()){
            pair p = pq.poll();
            int node = p.node;
            int distance = p.distance;
            for(pair it : adj.get((int)node)){
                int adjNode = it.node;
                int adjDis = it.distance;
                if(adjDis+distance < backArr[adjNode]){
                    backArr[adjNode]= adjDis+distance;
                    pq.offer(new pair(adjNode, adjDis+distance));
                }
            }
        }
        long shortestpath = frontArr[n-1];
        boolean[] ans = new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
            if(frontArr[edges[i][0]] + backArr[edges[i][1]] + edges[i][2] == shortestpath || frontArr[edges[i][1]] + backArr[edges[i][0]] + edges[i][2] == shortestpath){
                ans[i]=true;
            }
            else 
            ans[i] = false;
        }
        return ans;
    }
}
