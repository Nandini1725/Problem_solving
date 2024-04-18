class tuple{
    int row;
    int col;
    int dis;
    
    tuple(int row, int col, int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] ans = new int[n][m];
        Queue<tuple> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new tuple(i,j,0));
                    visited[i][j]=1;
                }
                else
                visited[i][j]=0;
            }
        }
        
        int[] dirRow = {-1,0,1,0};
        int[] dirCol = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dis = q.peek().dis;
            ans[row][col]= dis;
            q.remove();
            for(int i=0;i<4;i++){
                int newRow = row + dirRow[i];
                int newCol = col + dirCol[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && visited[newRow][newCol]!=1){
                    visited[newRow][newCol]=1;
                    q.add(new tuple(newRow, newCol, dis+1));
                }
            }
        }
        return ans;
    }
}
