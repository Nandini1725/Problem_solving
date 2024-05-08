class Solution {
    // Recursion

    public int solve(int[] nums, int i){
        if(i>=nums.length)
        return 0;

        if(i==nums.length-1)
        return 0;

        int min = nums.length;
        for(int j=1;j<=nums[i];j++){
            min = Math.min(min,1+solve(nums,i+j));
        }
        return min;
    }
    public int jump(int[] nums) {
        return solve(nums,0);
    }
    
    //--------------------------------------------------------------
    //Memoization
    
    public int solve(int[] nums, Integer[] memo,int i){
        if(i>=nums.length -1)
        return 0;
        if(memo[i] != null)
        return memo[i];

        int min = nums.length;
        for(int j=1;j<=nums[i];j++){
            min = Math.min(min, 1+ solve(nums,memo,i+j));
        }
        return memo[i]=min;
    }
    public int jump(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return solve(nums,memo,0);
    }

    //-------------------------------------------------------------------------
    //DP
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length-1]=0;
        
        for(int i=nums.length-2;i>=0;i--){
            int min = nums.length;
            for(int j=1;j<=nums[i];j++){
                if(j+i<=nums.length-1 && 1+dp[i+j]<min)
                min=1+dp[i+j];
            }
            dp[i]=min;
        }
        return dp[0];
    }
}
