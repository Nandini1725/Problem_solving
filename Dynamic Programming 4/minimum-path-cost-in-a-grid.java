class Solution {
    //recursive

    // private int dfs(int[][] grid, int row,int col, int[][] cost){
    //     if(row >= grid.length){
    //         return (int)1e4;
    //     } if(row == grid.length - 1){
    //         return grid[row][col];
    //     }
    //     int min = (int)1e4;
    //     for(int i = 0; i < grid[0].length; i++){
    //         min = Math.min(min, grid[row][col] + cost[grid[row][col]][i] + dfs(grid,row+1,i,cost));
    //     }
    //     return min;
    // }
    // public int minPathCost(int[][] grid, int[][] moveCost) {
    //     int minAns = (int)1e10;
    //     for(int i = 0; i < grid[0].length; i++){
    //         minAns = Math.min(minAns , dfs(grid, 0, i , moveCost));
    //     }
    //     return minAns;
    // }


//------------------------------------------------------------------------
    //memoization

    // Integer[][] memo;
    // public int minPathCost(int[][] grid, int[][] moveCost) {
    //     memo = new Integer[grid.length][grid[0].length];
    //     int minAns = (int)1e10;
    //     for(int i = 0; i < grid[0].length; i++){
    //         minAns = Math.min(minAns , dfs(grid, 0, i , moveCost));
    //     }
    //     return minAns;
    // }
    // private int dfs(int[][] grid, int r,int c, int[][] cost){
    //     if(r >= grid.length){
    //         return (int)1e4;
    //     } if(r == grid.length - 1){
    //         return grid[r][c];
    //     } if(memo[r][c] != null){
    //         return memo[r][c];
    //     }
    //     int minCost = (int)1e4;
    //     for(int i = 0; i < grid[0].length; i++){
    //         minCost = Math.min(minCost , grid[r][c] + cost[grid[r][c]][i] + dfs(grid,r+1,i,cost));
    //     }
    //     return memo[r][c] = minCost;
    // }

//--------------------------------------------------
    //tabulation
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i < n; i++){
            dp[m - 1][i] = grid[m - 1][i];
        }
        int minAns = (int)1e7;
        for(int row = m - 2; row >= 0; row--){
            for(int col = 0; col < n; col++){
                dp[row][col] = (int)1e5;
                for(int i = 0; i < n; i++){
                    int cost = grid[row][col] + moveCost[grid[row][col]][i] + dp[row + 1][i];
                    dp[row][col] = Math.min(dp[row][col] , cost);
                }
                if(row == 0) minAns = Math.min(minAns , dp[row][col]);
            }
        }
        return minAns;
    }
}
