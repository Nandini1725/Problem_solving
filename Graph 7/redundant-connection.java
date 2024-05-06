class DSU{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DSU(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(0);
        }
    }
    public int findUparent(int node){
        if(node==parent.get(node)) return node;

        int ulp = findUparent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v){
        int upu = findUparent(u);
        int upv = findUparent(v);

        if(upu==upv) return;
        if(size.get(upu)<size.get(upv)){
            parent.set(upv,upu);
            size.set(upv,size.get(upu)+size.get(upv));
        }
        else{
            parent.set(upv,upu);
            size.set(upu, size.get(upu)+size.get(upv));
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU ds = new DSU(edges.length);
        int extra = 0;
        int[] ans = new int[2]; 
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(ds.findUparent(u)==ds.findUparent(v)){
                ans[0]=u;
                ans[1]=v;
            }
            else
            ds.unionBySize(u,v);
        }
        return ans;
        
    }
}
