
class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0){
            return -1;
        }
        
        int edges = 0;
        int n = points.length;
        int totalWeight = 0;
        UnionFind uf = new UnionFind(n);
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)-> a[2] - b[2]);
        
        for(int i=0;i<points.length;i++){
            int[] coords = points[i];
            int x1 = coords[0];
            int y1 = coords[1];            
            for(int j=i+1;j<points.length;j++){
                int[] coords2 = points[j];
                int x2 = coords2[0];
                int y2 = coords2[1];
                int weight = Math.abs(x1 - x2) + Math.abs(y1-y2);
                queue.offer(new int[]{i, j, weight});
            }
        }
        while(!queue.isEmpty() && edges < n-1){
            int[] edge = queue.poll();
            if(uf.isConnected(edge[0], edge[1])){
                continue;
            }
            uf.union(edge[0], edge[1]);
            totalWeight += edge[2];
            edges++;
        }
        return totalWeight;
    }
    public class UnionFind{
        private int[] root;
        private int[] rank;
        
        public UnionFind(int n){
            this.root = new int[n];
            this.rank = new int[n];
            
            for(int i=0;i<n;i++){
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }
        private void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            
            if(rootY == rootX){
                return;
            }
            
            if(rank[rootY] > rank[rootX]){
                root[rootX] = rootY;
            }
            else if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }
            else{
                root[rootY] = rootX;
                rank[rootY]++;
            }
        }
        private int find(int x){
            if(root[x] == x){ 
                return x;
            }
            return root[x] = find(root[x]);
        }
        private boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
}
