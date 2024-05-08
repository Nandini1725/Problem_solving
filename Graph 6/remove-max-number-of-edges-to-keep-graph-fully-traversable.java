class DSU{
    private int[] parent;
    private int[] size;
    public int cnt;

    public DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        cnt=n;
    }
    public int findUparent(int node){
        if(parent[node]!=node){
            parent[node]=findUparent(parent[node]);
        }
        return parent[node];
    }

    public boolean unionBySize(int u, int v){
        int upu = findUparent(u-1);
        int upv = findUparent(v-1);
        if(upu==upv) return false;
        if(size[upu]>size[upv]){
            parent[upv]=parent[upu];
            size[upu] += size[upv];
        }
        else{
            parent[upu]=parent[upv];
            size[upv]+= size[upu];
        }
        --cnt;
        return true;
    }
}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int edgesToRemove = 0;
        for(int[] edge : edges){
            int color = edge[0];
            int u = edge[1];
            int v = edge[2];
            if(color==3){
                if(!alice.unionBySize(u,v))
                edgesToRemove++;
                else
                bob.unionBySize(u,v);
            }
        }
        for(int[] edge : edges){
            int color = edge[0];
            int u = edge[1];
            int v = edge[2];
            if(color==1 && !alice.unionBySize(u,v))
            edgesToRemove++;
            if(color==2 && !bob.unionBySize(u,v))
            edgesToRemove++;
        }
        if(alice.cnt ==1 && bob.cnt==1)
        return edgesToRemove;
        else
        return -1;
    }
}
