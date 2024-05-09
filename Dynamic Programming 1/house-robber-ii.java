class Solution {
  //Recursion
    public int solve(int[] nums, int start, int n){
        if(n==start) return nums[start];
        if(n<start) return 0;
        int pick = solve(nums,start,n-1);
        int notpick = solve(nums,start,n-2)+nums[n];
        return Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
        return nums[0];

        int notpick = solve(nums,0, n-2);
        int pick = solve(nums,1,n-1);
        return Math.max(notpick,pick);
    }
  //-------------------------------------------------------------------------------------------------------------------------
  //Memoization
  int[][] memo;
    public int solve(int[] nums, int start, int n, int i){
        if(n==start) return memo[n][i] = nums[start];
        if(n<start) return 0;
        if(memo[n][i]!=-1) return memo[n][i];

        int pick = solve(nums,start,n-1,i);
        int notpick = solve(nums,start,n-2,i)+nums[n];
        return memo[n][i] = Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
        return nums[0];
        memo = new int[nums.length+1][2];
        for(int[] i : memo){
            Arrays.fill(i,-1);
        }
        int notpick = solve(nums,0, n-2,0);
        int pick = solve(nums,1,n-1,1);
        return Math.max(notpick,pick);
    }

  //--------------------------------------------------------------------------------------------------------------------
  //DP
   public int solve(int[] nums, int start, int end, int[][] dp, int i){
        dp[start][i] = nums[start-1];
        for(int j=start;j<end;j++){
            dp[j+1][i] = Math.max(dp[j][i],dp[j-1][i]+nums[j]);
        }
        return dp[end][i];
    }
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        if(nums.length==1) return nums[0];

        int pick = solve(nums,1,nums.length-1,dp,0);
        int notpick = solve(nums,2,nums.length,dp,1);
        return Math.max(pick,notpick);
    }
}
