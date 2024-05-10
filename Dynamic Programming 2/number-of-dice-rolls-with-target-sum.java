class Solution {
    //Recursion
    // public int solve(int n , int k, int target, int m){
    //     if(n==0 || target<0){
    //         if(target==0) return 1;
    //         else return 0;
    //     }
    //     int ans =0;
    //     for(int i=1;i<=k;i++){
    //         ans += solve(n-1,k,target-i,m)%m;
    //     }
    //     return ans;
    // }
    // public int numRollsToTarget(int n, int k, int target) {
    //     int m = (int)(1e9);
    //     return solve(n,k,target,m);
    // }

    //---------------------------------------------------------------
    //Memoization
    // int m = 1_000_000_007;

    // public int solve(int n, int k, int target, Integer[][] memo) {
	// 	if (n == 0 || target < 0)
	// 		return target == 0 ? 1 : 0;

	// 	if (memo[n][target] != null)
	// 		return memo[n][target];

	// 	int ways = 0;

	// 	for (int i = 1; i <= k; i++)
	// 		ways = (ways + solve(n - 1, k, target - i, memo)) % m;

	// 	return memo[n][target] = ways;
	// }
	// public int numRollsToTarget(int n, int k, int target) {
	// 	Integer[][] memo = new Integer[n + 1][target + 1];
	// 	return solve(n, k, target, memo);
	// }

    //--------------------------------------------------------------------
    //DP
    // public int numRollsToTarget(int n, int k, int target) {
	  // 	int m = 1_000_000_007;
    //     int[][] dp = new int[n+1][target+1];
    //     dp[0][0]=1;
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=target;j++){
    //             for(int p=1;p<=k;p++){
    //                 if(j>=p)
    //                 dp[i][j] = (dp[i][j] + dp[i-1][j-p])%m;
    //                 else
    //                 break;
    //             }
    //         }
    //     }
    //     return dp[n][target];

	// }
    public int numRollsToTarget(int n, int k, int target) {
		int m =1_000_000_007;
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=target;j>=0;j--){
                dp[j]=0;
                for(int t=1;t<=k;t++){
                    if(j>=t)
                    dp[j] = (dp[j]+dp[j-t])%m;
                    else 
                    break;
                }
            }
        }
        return dp[target];
	}
}
