class Solution {
    //Recursion
    // public int solve(int i, int j, String word1, String word2){
    //     if(i<0) return j+1;
    //     if(j<0) return i+1;
    //     if(word1.charAt(i)==word2.charAt(j)) 
    //     return solve(i-1,j-1,word1,word2);

    //     int replace = solve(i-1,j-1,word1,word2);
    //     int delete = solve(i-1,j,word1,word2);
    //     int addition = solve(i,j-1,word1,word2);

    //     return Math.min(addition, Math.min(replace,delete))+1;
    // }
    // public int minDistance(String word1, String word2) {
    //     int word1Length = word1.length();
    //     int word2Length = word2.length();

    //     return solve(word1Length-1,word2Length-1,word1,word2);
    // }

    //-------------------------------------------------------------------------------
    //Memoization
    // public int solve(int i, int j, String word1, String word2, int[][] memo){
    //     if(i<0) return j+1;
    //     if(j<0) return i+1;
    //     if(word1.charAt(i)==word2.charAt(j)) 
    //     return solve(i-1,j-1,word1,word2,memo);

    //     if(memo[i][j]!=-1) return memo[i][j];
    //     int replace = solve(i-1,j-1,word1,word2,memo);
    //     int delete = solve(i-1,j,word1,word2,memo);
    //     int addition = solve(i,j-1,word1,word2,memo);

    //     return memo[i][j]= Math.min(addition, Math.min(replace,delete))+1;
    // }
    // public int minDistance(String word1, String word2) {
    //     int word1Length = word1.length();
    //     int word2Length = word2.length();

    //     int[][] memo = new int[word1Length][word2Length];
    //     for(int[] i : memo){
    //         Arrays.fill(i,-1);
    //     }
    //     return solve(word1Length-1,word2Length-1,word1,word2,memo);
    // }

    //---------------------------------------------------------------------------
    //DP
    // public int minDistance(String word1, String word2) {
    //     int word1Length = word1.length();
    //     int word2Length = word2.length();

    //     int[][] dp = new int[word1Length+1][word2Length+1];
        
    //     for(int i=0;i<=word1Length;i++)
    //     dp[i][0]=i;

    //     for(int j=0;j<=word2Length;j++)
    //     dp[0][j]=j;

    //     for(int i=1;i<=word1Length;i++){
    //         for(int j=1;j<=word2Length;j++){
    //             if(word1.charAt(i-1)==word2.charAt(j-1))
    //             dp[i][j]=dp[i-1][j-1];

    //             else{
    //                 int replace = dp[i-1][j-1];
    //                 int addition = dp[i][j-1];
    //                 int delete = dp[i-1][j];
    //                 dp[i][j] = Math.min(addition, Math.min(replace,delete))+1;
    //             }
    //         }
    //     }
    //     return dp[word1Length][word2Length];
    // }

    //------------------------------------------------------------------
    //Space Complexity : O(n);
    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();

        int[] dp1 = new int[word2Length+1];
        
        for(int j=0;j<=word2Length;j++)
        dp1[j]=j;

        for(int i=1;i<=word1Length;i++){
            int[] dp2 = new int[word2Length+1];
            dp2[0]=i; 
            for(int j=1;j<=word2Length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                dp2[j]=dp1[j-1];

                else{
                    int replace = dp1[j-1];
                    int addition = dp2[j-1];
                    int delete = dp1[j];
                    dp2[j] = Math.min(addition, Math.min(replace,delete))+1;
                }
            }
            dp1=dp2;
        }
        return dp1[word2Length];
    }
}
