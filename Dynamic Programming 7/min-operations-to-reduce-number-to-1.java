public static int minStepsTo1(int n) {
        int[] dp = new int[n+1];

        dp[1] = 0;
        for(int i=2;i<=n;i++){
            if(n%2==0 && n%3==0) {
                dp[i] = Math.min(Math.min(dp[i/2], dp[i/3]), dp[i-1]) + 1;
            } else if(n%2==0) {
                dp[i] = Math.min(dp[i/2],dp[i-1]) + 1;
            } else if(n%3==0) {
                dp[i] = Math.min(dp[i/3],dp[i-1]) + 1;
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }
        return dp[n];
}
