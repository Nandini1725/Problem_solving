//recursion + memoization
// class Solution{

//     public int solve(int[][] dungeon, int i, int j,int[][] memo){
//         if(i>=dungeon.length || j>=dungeon[0].length)
//         return Integer.MAX_VALUE;

//         if(i==dungeon.length-1 && j==dungeon[0].length-1)
//         return Math.max(1,1-dungeon[i][j]);

//         if(memo[i][j] != -1)
//         return memo[i][j];

//         int ans = Math.min(solve(dungeon,i+1,j,memo), solve(dungeon,i,j+1, memo))-dungeon[i][j];
//         ans = Math.max(1,ans);
//         return memo[i][j]=ans;
//     }
//     public int calculateMinimumHP(int[][] dungeon){
//         int[][] memo= new int[dungeon.length][dungeon[0].length];

//         for(int i =0; i<dungeon.length;i++){
//             Arrays.fill(memo[i],-1);
//         }
//         return solve(dungeon,0,0,memo);
//     }
// }

//---------------------------------------------------------------------

//Binary Search
// class Pair {
//         int health;
//         boolean bool;

//         Pair(int health, boolean canReach) {
//             this.health = health;
//             this.bool = bool;
//         }
//     }
// class Solution {
    
//     public Pair[][] dp;
    
//     public boolean reach(int i, int j, int[][] dungeon,int mid){
//         if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
//             return (mid + dungeon[i][j] > 0);
//         }
//         if (i >= dungeon.length || j >= dungeon[0].length || mid + dungeon[i][j] <= 0) {
//             return false;
//         }
//         if (dp[i][j].health != -1 && dp[i][j].health > mid + dungeon[i][j]) {
//             return dp[i][j].bool;
//         }

//         boolean ans = false;
//         ans = ans || reach(i+1,j, dungeon, mid + dungeon[i][j]);
//         ans = ans || reach(i,j+1, dungeon, mid + dungeon[i][j]);

//         dp[i][j].health = Math.max(dp[i][j].health, mid + dungeon[i][j]);
//         return dp[i][j].bool = ans;
//     }
//     public boolean solve(int mid, int[][] dungeon){
//         dp = new Pair[dungeon.length + 1][dungeon[0].length + 1];
//         for (int i = 0; i <= dungeon.length; i++) {
//             for (int j = 0; j <= dungeon[0].length; j++) {
//                 dp[i][j] = new Pair(-1, false);
//             }
//         }
//         return reach(0, 0, dungeon, mid);
//     }
//     public int calculateMinimumHP(int[][] dungeon) {
//         int start = 1;
//         int end = (int)1e9;
//         int ans =0;

//         while(start<=end){
//             int mid = (start+end)/2;
//             if(solve(mid, dungeon)){
//                 ans = mid;
//                 end = mid-1;
//             }
//             else
//             start = mid+1;
//         }
//         return ans;
//     }
// }

//--------------------------------------------------------------------------------
//DP
class Solution{
    public int calculateMinimumHP(int[][] dungeon){
        int[][] dp = new int[dungeon.length+1][dungeon[0].length+1];
        for(int i=0;i<=dungeon.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[dungeon.length][dungeon[0].length-1]=1;
        dp[dungeon.length-1][dungeon[0].length]=1;

        for(int i= dungeon.length-1;i>=0;i--){
            for(int j=dungeon[0].length-1;j>=0;j--){
                int min = Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j];
                if(min<=0)
                dp[i][j] = 1;
                else
                dp[i][j]=min;
            }
        }
        return dp[0][0];
    }
}
