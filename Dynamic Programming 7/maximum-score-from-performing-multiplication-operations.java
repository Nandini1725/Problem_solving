class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n=nums.length,m=multipliers.length;
        int dp[][] = new int[m][m];
        for(int d[]:dp)
        Arrays.fill(d,Integer.MIN_VALUE);

        return solve(nums,multipliers,0,n-1,dp);
    }
    public int solve(int[] nums,int[] multipliers,int i,int j,int dp[][]){
        
        int n =nums.length;
        int m=multipliers.length;
        int index = i+(n-1-j);
        if(index==m)
            return 0;
        
        if(dp[i][j-(n-m)]!=Integer.MIN_VALUE)
            return dp[i][j-(n-m)];
        
        int pick =  nums[i]*multipliers[index] +  solve(nums,multipliers,i+1,j,dp);
        int notpick = nums[j] * multipliers[index] + solve(nums,multipliers,i,j-1,dp);
        
        return dp[i][j-(n-m)] = Math.max(pick,notpick);
        
    }
}
