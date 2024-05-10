class Solution
{
    //Recursion
    // public long countFriendsPairings(int n) 
    // { 
    //   if(n==0) return 1;
       
    //   int mod = 10^9+7;
    //   long pair=0;
    //   long single = countFriendsPairings(n-1);
       
    //   if(n-2>=0)
    //   pair = countFriendsPairings(n-2)*(n-1);
       
    //   return (single+pair)%mod;
    // }
    
    //--------------------------------------------------------------------------
    //Memoization
    
    // public long solve(long[] memo, int n){
    //     if(n==0) return 1;
        
    //     if(memo[n]!=-1) return memo[n];
        
        
    //     long single = solve(memo,n-1);
    //     long pair=0;
        
    //     if(n-2>=0) 
    //     pair = solve(memo,n-2)*(n-1);
        
    //     return memo[n]= (single+pair)% 1000000007;
    // }
    // public long countFriendsPairings(int n) 
    // { 
    //   long[] memo = new long[n+1];
    //   Arrays.fill(memo,-1);
    //   return solve(memo,n);
    // }
    
    //----------------------------------------------------------------------------
    //DP
    public long countFriendsPairings(int n) 
    { 
      long[] dp =  new long[n+1];
      Arrays.fill(dp,-1);
      dp[0]=1;
      for(int i=1;i<=n;i++){
          long pair=0;
          long single = dp[i-1];
          if(i-2>=0)
          pair = dp[i-2]*(i-1);
          
          dp[i]=(single + pair)%1000000007;
      }
      return dp[n];
    }
}    
 
