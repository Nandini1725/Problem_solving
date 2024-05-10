class Solution {
    //Recursion
    // public int solve(String s, int n, int i){
    //     if(i==n)
    //     return 1;
    //     if(s.charAt(i)=='0')
    //     return 0;

    //     int count = solve(s,n,i+1);
    //     if(i+1 <n && ((s.charAt(i)-'0')*10 +s.charAt(i+1)-'0')<=26)
    //     count+= solve(s,n,i+2);

    //     return count;
    // }
    // public int numDecodings(String s) {
    //     int n = s.length();
    //     return solve(s,n,0);
    // }

    //---------------------------------------------------------------------------------------
    //Memoization

    // public int solve(String s, int n, int i, int[] memo){
    //     if(i==n)
    //     return 1;

    //     if(s.charAt(i)=='0')
    //     return 0;

    //     if(memo[i]!=-1)
    //     return memo[i];

    //     int cnt = solve(s,n,i+1,memo);
    //     if(i+1<n && ((s.charAt(i)-'0')*10 + s.charAt(i+1)-'0') <= 26)
    //     cnt+= solve(s,n,i+2,memo);

    //     return memo[i]=cnt;
    // }
    // public int numDecodings(String s) {
    //     int n = s.length();
    //     int[] memo = new int[n];
    //     Arrays.fill(memo,-1);
    //     return solve(s,n,0,memo);
    //}

    //-----------------------------------------------------------------------
    //DP
    // public int numDecodings(String s) {
    //     int n = s.length();
    //     int[] dp = new int[n+1];
    //     dp[n]=1;

    //     for(int i=n-1;i>=0;i--){
    //         if(s.charAt(i)!='0'){
    //             dp[i]=dp[i+1];
    //             if(i+1<n && ((s.charAt(i)-'0')*10 + s.charAt(i+1)-'0')<=26 )
    //             dp[i]+=dp[i+2];
    //         }
    //     }
    //     return dp[0];
    // }

    //--------------------------------------------------------------------------------
    //Space optimization
    public int numDecodings(String s) {
        int n =s.length();
        int u =0;
        int v =1;
        for(int i=n-1;i>=0;i--){
            int curr = 0;
            if(s.charAt(i)!='0'){
                curr=v;
                if(i+1<n && ((s.charAt(i)-'0')*10 + s.charAt(i+1)-'0')<=26)
                curr+=u;
            }
            u=v;
            v=curr;
        }
        return v;
    }
}
