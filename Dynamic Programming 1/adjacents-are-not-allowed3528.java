class Solution{
    static int maxSum(int N, int mat[][])
    {
        int[] dp = new int[N+1];
        Arrays.fill(dp,0);
        dp[0]=0;
        dp[1] = Math.max(mat[0][0],mat[1][0]);
        for(int i=2;i<=N;i++){
            dp[i] = Math.max(Math.max(mat[0][i-1],mat[1][i-1])+dp[i-2] , dp[i-1]);
        }
        return dp[N] ;
    }
}
