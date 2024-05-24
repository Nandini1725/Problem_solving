class Solution {
    //Recursion
    // public int solve(int i, int prev, int[] nums){
    //     if(i==nums.length)
    //     return 0;

    //     int take = 0;        
    //     int notTake = solve(i+1,prev,nums);

    //     if(prev==-1 || nums[prev]<nums[i])
    //     take = 1+solve(i+1,i,nums);

    //     return Math.max(take,notTake);
    // }
    // public int lengthOfLIS(int[] nums) {
    //     return solve(0,-1,nums);
    // }

    //------------------------------------------------------------------------------

    //Memoization
    
    // public int solve(int i, int prev, int[] nums, int[][] memo){
    //     if(i==nums.length)
    //     return 0;

    //     if(memo[i][prev+1]!=-1)
    //     return memo[i][prev+1];

    //     int take =0;
    //     int notTake = solve(i+1,prev,nums,memo);

    //     if(prev==-1 || nums[i]>nums[prev])
    //     take = 1 + solve(i+1,i,nums,memo);

    //     return memo[i][prev+1]=Math.max(take, notTake);
    // }
    // public int lengthOfLIS(int[] nums) {
    //     int[][] memo = new int[nums.length][nums.length+1];
    //     for(int[] i : memo){
    //         Arrays.fill(i,-1);
    //     }
    //     return solve(0,-1,nums,memo);
    // }

    //------------------------------------------------------------------------------

    //DP

    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     if(n==1)
    //     return 1;

    //     int ans =0;
    //     int[] dp = new int[n];
    //     dp[0]=1;

    //     for(int i=1; i<n;i++){
    //         int maxLisSize = 0;
    //         for(int j=0;j<=i-1;j++){
    //             if(nums[i]>nums[j]){
    //                 maxLisSize = Math.max(maxLisSize, dp[j]);
    //             }
    //         }
    //         dp[i] = maxLisSize + 1;
    //         ans = Math.max(ans,dp[i]);
    //     }
    //     return ans;
    // }

    //-----------------------------------------------------------------------

    //Binary Search
    public int lengthOfLIS(int[] nums){
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int ind = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<arr[ind]){
                int low =0;
                int high = ind;
                while(low<=high){
                    int mid = (low+high)/2;
                    if(arr[mid]<nums[i])
                    low = mid+1;
                    else
                    high = mid-1;
                }
                arr[low]=nums[i];
            }
            else if(arr[ind]!=nums[i]){
                ind++;
                arr[ind]=nums[i];
            }
        }
        return ind+1;
    }
}
