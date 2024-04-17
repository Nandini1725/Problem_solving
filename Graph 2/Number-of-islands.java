class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second; 
    }
}

class Solution {
    public void bfs(int i, int j, char[][] grid, int[][] visited){
        visited[i][j] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i,j));
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()){
            int one = q.peek().first;
            int two = q.peek().second;
            q.remove();
            
            for(int dirRow =-1; dirRow<=1; dirRow++){
                for(int dirCol = -1; dirCol<=1; dirCol++){
                    int newRow = one + dirRow;
                    int newCol = two + dirCol;
                    if(Math.abs(dirRow-dirCol)==1 && newRow>=0 && newRow<n && newCol>=0 && newCol<m &&
                    grid[newRow][newCol]=='1' && 
                    visited[newRow][newCol]==0 ){
                        visited[newRow][newCol]= 1;
                        q.add(new Pair(newRow,newCol));
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }
}
