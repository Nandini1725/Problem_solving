class Solution {
    //Recursion
    // public int solve(int i, int j , int n, int m, int[][] grid){
    //     if(i>=n || j>=m)
    //     return Integer.MAX_VALUE;

    //     if(i==n-1 && j==m-1)
    //     return grid[i][j];

    //     return grid[i][j] + Math.min(solve(i+1,j,n,m,grid),solve(i,j+1,n,m,grid));
    // }
    // public int minPathSum(int[][] grid) {
    //     return solve(0,0,grid.length,grid[0].length,grid);
    // }

    //-------------------------------------------------------------------------------
    //Memoization
    // public int solve(int i, int j, int n, int m, int[][] grid, int[][] memo){
    //     if(i>=n || j>=m)
    //     return Integer.MAX_VALUE;

    //     if(i==n-1 && j==m-1)
    //     return grid[i][j];

    //     if(memo[i][j]!=-1)
    //     return memo[i][j];

    //     return memo[i][j] = grid[i][j] + Math.min(solve(i+1,j,n,m,grid,memo), solve(i,j+1,n,m,grid,memo));
    // }
    // public int minPathSum(int[][] grid) {
    //     int[][] memo = new int[grid.length+1][grid[0].length+1];
    //     for(int[] i: memo)
    //     Arrays.fill(i,-1);

    //     return solve(0,0,grid.length,grid[0].length,grid,memo);
    // }

    //-------------------------------------------------------------------------------------------------
    //DP
    public int minPathSum(int[][] grid){
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0)
                grid[i][j] = grid[i][j];

                else if(i==0 && j!=0)
                grid[i][j] += grid[i][j-1];

                else if(i!=0 && j==0)
                grid[i][j] += grid[i-1][j];

                else 
                grid[i][j] += Math.min(grid[i][j-1] , grid[i-1][j]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
