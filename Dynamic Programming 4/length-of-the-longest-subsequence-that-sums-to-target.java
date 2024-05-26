class Solution {
    private int solve(List<Integer> nums, int i, int target, Integer[][] dp) {
        if(target == 0) {
            return 1;
        }
        if(target < 0 || i < 0) {
            return 0;
        }
        
        if(dp[i][target] != null) {
            return dp[i][target];
        }
        
        int take = solve(nums, i-1, target-nums.get(i), dp);
        int notTake = solve(nums, i-1, target, dp);
        int res = 0;
        if(take == 0 && notTake == 0) {
            res = 0;
        } else {
            res = Math.max(take+1, notTake);
        }
        return dp[i][target] = res;
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        return solve(nums, nums.size()-1, target, new Integer[nums.size()][target+1])-1;
    }
}
