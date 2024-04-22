public class Solution {
    public int knight(int A, int B, int C, int D, int E, int F) {
        if(C==E && D ==F)
        return 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{C-1, D-1, 0});
        
        boolean visited[][] = new boolean[A][B];
        visited[C-1][D-1] = true;
        
        int dirs[][] = {{-2,-1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        while(!q.isEmpty()){
            int element[] = q.poll();
            int x = element[0];
            int y = element[1];
            int steps = element[2];
            if(x==E-1 && y==F-1)
            return steps;
            for(int dir[] : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx<0 || nx>=A || ny<0 || ny>=B || visited[nx][ny])
                continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, steps+1});
            }
        }
        return -1;
    }
}
