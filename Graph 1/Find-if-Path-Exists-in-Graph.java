class Solution {
    public int[] link;
    public int merge(int x){
        if(link[x]!=x)
        link[x] = merge(link[x]);

        return link[x];
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        link = new int[n];
        for(int i=0;i<n;i++){
            link[i]=i;
        }

        for(int[] edge: edges){
            link[merge(edge[0])] = merge(edge[1]);
        }
        return merge(source)==merge(destination);
    }
}
