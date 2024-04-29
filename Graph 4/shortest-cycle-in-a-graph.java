class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        int min = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<n;i++){
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);

            int[] visited = new int[n];

            distance[i]=0;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            while(!q.isEmpty()){
                int node = q.poll();

                for(int it: list.get(node)){
                    if(distance[it]==Integer.MAX_VALUE){
                        distance[it]=1+distance[node];
                        visited[it]=node;
                        q.add(it);
                    }
                    else if(visited[node]!=it && visited[it]!=node)
                    min = Math.min(min, distance[node]+distance[it]+1);
                }
            }
        }
        if(min==Integer.MAX_VALUE)
        return -1;
        else
        return min;
    }
}
