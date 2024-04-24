class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjacentList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjacentList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjacentList.get(prerequisites[i][1]).add(prerequisites[i][0]);
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
        int[] ans = new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans[i++]=node;

            for(int it : adjacentList.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(i==numCourses) return ans;
        return new int[0];
    }
}
