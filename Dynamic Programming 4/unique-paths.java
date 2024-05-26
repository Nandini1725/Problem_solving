class Solution {
    int[][] dp ;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0; i<m; i++){
          int j = 0;
          if(i==0) j++;
          for(;j<n; j++){   
            if(isValid( i,j-1,m,n)) dp[i][j] += dp[i][j-1];
            if(isValid(i-1,j,m,n)) dp[i][j] += dp[i-1][j];  
          }
        }
        return dp[m-1][n-1];
    }

    public boolean isValid (int i,int j ,int m ,int n){
      return (i>=0 && i<m && j>=0 && j<n);
    }
}
