class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjacentList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjacentList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjacentList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it: adjacentList.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
            q.add(i);
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            list.add(node);

            for(int it : adjacentList.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(list.size()==numCourses) return true;
        return false;
    }
}
