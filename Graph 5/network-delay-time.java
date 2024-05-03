class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        int[] dist = new int[n+1];
        for(int i=0;i<=n;i++){
            dist[i] = (int)(1e9);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.first - y.first);
        pq.offer(new Pair(0,k));
        dist[k]=1;
        while(!pq.isEmpty()){
            Pair p = pq.peek();
            int dis = p.first;
            int node = p.second;
            pq.poll();
            for(Pair it: adj.get(node)){
                int adgeNode = it.first;
                int edgeW = it.second;
                if(dis + edgeW < dist[adgeNode]){
                    dist[adgeNode] = dis + edgeW;
                    pq.offer(new Pair(dist[adgeNode], adgeNode));
                }
            }
        }
        int ans = dist[1];
        for(int i=1;i<=n;i++){
            if(dist[i]==1e9)
            return -1;
            else
            ans = Math.max(ans,dist[i]);
        }
        return ans;
    }
}
