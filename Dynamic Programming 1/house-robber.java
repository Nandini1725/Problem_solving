class Solution {
  //Recursion
    public int solve(int[] nums, int i){
        if(i>=nums.length)
        return 0;
        int sum = Math.max(nums[i] + solve(nums,i+2),solve(nums,i+1));
        return sum;
    }
    public int rob(int[] nums) {
        return solve(nums,0);
    }
//-----------------------------------------------------------------------------------------------------------------------------------
  //Memoization
  public int solve(int[] nums, int i, int[] memo){
        if(i>=nums.length)
        return 0;

        if(memo[i]!=-1)
        return memo[i];

        int ans = Math.max(nums[i]+solve(nums,i+2,memo),solve(nums,i+1,memo));
        return memo[i]=ans;
    }
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        memo[i]=-1;
        return solve(nums,0,memo);
    }

  //----------------------------------------------------------------------------------------------------------------------------------
  //DP
  public int solve(int[] nums,int[] dp){
        for(int i=2;i<=nums.length;i++){
            int pick = nums[i-1] + dp[i-2];
            int notpick = dp[i-1];

            dp[i]= Math.max(pick,notpick);
        }
        return dp[nums.length];
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        return solve(nums,dp);
    }
}
