class Pair{
    int d;
    int w;
    
    Pair(int d, int w){
        this.d=d;
        this.w=w;
    }
}

class Solution {
    
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        
        List<List<Pair>> adj = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(new Pair( v, 0 ));
            adj.get(v).add(new Pair(u, 1 ));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
         dist[src] = 0;
         
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        pq.offer(new Pair (src, 0 ));

        while (!pq.isEmpty()) {
            
            Pair p = pq.poll();
            int u = p.d;
            visited[u] = true;

            for (Pair x : adj.get(u)) {
                int v = x.d;
                int wt = x.w;

                if (!visited[v] && dist[v] > dist[u] + wt) {
                    dist[v] = dist[u] + wt;
                    pq.offer(new Pair (v, dist[v] ));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE? -1: dist[dst];
    }
}
