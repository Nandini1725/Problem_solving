class Solution {
    //Recursion
    public int numSquares(int n) {
        if(n<4) return n;

        int min = n;
        for(int i=1;i*i<=n;i++){
            int square = i*i;
            min = Math.min(min, 1 + numSquares(n-square));
        }
        return min;
    }
  //----------------------------------------------------------------------------------------------------
  //memoization
  public int numSquares(int n) {
        int[] memo = new int[n+1];
        return solve(n,memo);
    }
    public int solve(int n, int[] memo){
        if(n<4) return n;
        
        if(memo[n]!=0)
        return memo[n];

        int min = n;
        for(int i=1;i*i<=n;i++){
            int square = i*i;
            min = Math.min(min, 1 + solve(n-square,memo));
        }
        return memo[n]=min;
    }
  //--------------------------------------------------------------------------------------------------
  //DP
  public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;

        for(int i=1;i<=n;i++){
            dp[i]=i;
            for(int j=1;j*j<=i;j++){
                int square = j*j;
                dp[i]=Math.min(dp[i],1+dp[i-square]);
            }
        }
        return dp[n];
    }
}
