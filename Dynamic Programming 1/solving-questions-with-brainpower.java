class Solution {
    //Recursion
    // public long solve(int i, int[][] questions){
    //     if(i>=questions.length) return 0;
    //     long take = questions[i][0] + solve(i+questions[i][1]+1, questions);
    //     long notTake = solve(i+1,questions);
    //     return Math.max(take,notTake);
    // }
    // public long mostPoints(int[][] questions) {
    //     return solve(0,questions);
    // }

    //--------------------------------------------------------------------------------
    //Memoization
    // public long solve(int i, int[][] questions, long[] memo){
    //     if(i>=questions.length)
    //     return 0;
    //     if(memo[i]!=0)
    //     return memo[i];

    //     long take  = questions[i][0] + solve(i+questions[i][1]+1, questions, memo);
    //     long notTake = solve(i+1, questions, memo);
    //     return memo[i]=Math.max(take,notTake);
    // }
    // public long mostPoints(int[][] questions) {
    //     long[] memo = new long[questions.length];
    //     return solve(0,questions,memo);
    // }

    //-----------------------------------------------------------------------------
    //DP
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length+1];
        for(int i=questions.length-1;i>=0;i--){
            long take = 0;
            if(i+questions[i][1] + 1 <questions.length)
            take = dp[i+questions[i][1]+1];

            long notTake = dp[i+1];
            dp[i] = Math.max(questions[i][0]+take, notTake);
        }
        return dp[0];
    }
}
