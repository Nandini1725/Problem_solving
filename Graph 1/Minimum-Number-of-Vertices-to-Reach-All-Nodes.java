class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        List<Integer> list = new LinkedList<>();
        
        for(List<Integer> it : edges){
            indegree[it.get(1)]++;
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==0)
            list.add(i);
        }
        return list;
    }
}
