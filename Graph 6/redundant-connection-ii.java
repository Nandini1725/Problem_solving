class DSU{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    public DSU(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
        }
    }
    public int findUparent(int node){
        if (parent.get(node) != node) {
            int ulp = findUparent(parent.get(node));
            parent.set(node,ulp);
        }
        return parent.get(node); 
    }
    public boolean union(int u, int v){
        int upu = findUparent(u);
        int upv = findUparent(v);
        if(upu==upv)
        return false;

        if (rank.get(upu) < rank.get(upv)) {
            parent.set(upu, upv);
        } else if (rank.get(upu) > rank.get(upv)) {
            parent.set(upv, upu);
        } else {
            parent.set(upu, upv);
            rank.set(upv, rank.get(upv) + 1);
        }

        return true;
    }
}
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        DSU ds = new DSU(edges.length);
        int n = edges.length;
        int[] parent = new int[n + 1]; 
        for (int i = 1; i <= n; i++) {
            parent[i] = i; 
        }
        int conflict=-1;
        int cycle=-1;
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(parent[v]!=v){
                conflict = i;
            }
            else{
                parent[v]=u;
                if(!ds.union(u,v))
                cycle = i;
            }
        }
        if (conflict == -1) { 
            return edges[cycle];
        }
        int u = edges[conflict][0];
        int v = edges[conflict][1];

        if (cycle == -1) {
            return new int[]{u, v}; 
        }
        return new int[]{parent[v], v};
        
    }
}
