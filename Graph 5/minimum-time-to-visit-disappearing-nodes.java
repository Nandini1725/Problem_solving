class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] list = new List[n];
        Arrays.setAll(list,k -> new ArrayList<>());
        for(var it : edges){
            int u = it[0];
            int v = it[1];
            int w = it[2];
            list[u].add(new int[] {v,w});
            list[v].add(new int[] {u,w});
        }

        int[] d = new int[n];
        Arrays.fill(d, (int)(1e9));
        d[0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            var x = pq.poll();
            int distance = x[0];
            int node = x[1];

            if(distance>d[node]){
                continue;
            }
            for(var it: list[node]){
                int v = it[0];
                int w = it[1];
                if(d[v]>d[node]+w && d[node]+w <disappear[v]){
                    d[v] = d[node]+w;
                    pq.offer(new int[] {d[v],v});
                }
            }
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = d[i] < disappear[i] ? d[i] : -1;
        }
        return ans;
    }
}
