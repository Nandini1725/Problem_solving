class Solution {
    private int[] parent;
    private int findUparent(int node){
        if(parent[node]!=node)
        parent[node]=findUparent(parent[node]);

        return parent[node];
    }
    public int minSwapsCouples(int[] row) {
        int n= row.length>>1;
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i< n<<1;i+=2){
            int p1 = row[i]>>1;
            int p2 = row[i+1]>>1;
            parent[findUparent(p1)]=findUparent(p2);
        }
        int swaps = n;
        for(int i=0;i<n;i++){
            if(i==findUparent(i))
            swaps--;
        }
        return swaps;
    }
}
