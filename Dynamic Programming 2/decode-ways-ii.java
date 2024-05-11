class Solution {
    //Recursion + Memoization

    // public int m = 1000000007;
    // public long solve(int i, String s, long[] dp){
    //     if(i>=s.length())
    //     return 1L;
    //     if(s.charAt(i)=='0')
    //     return 0;
    //     if(dp[i]!=-1)
    //     return dp[i];
    //     long a=0,b=0;

    //     if(s.charAt(i)=='*'){
    //         a=solve(i+1,s,dp)*9;
    //         b=solve(i+2,s,dp);
    //         if(s.charAt(i+1)=='*')
    //         b*=15;
    //         else
    //         if(s.charAt(i+1)<='6')
    //         b*=2;
    //     }
    //     else{
    //         if(s.charAt(i+1)!='0')
    //         a=solve(i+1,s,dp);
    //         if(s.charAt(i+1)=='*' && (i!=s.length()-2 || s.charAt(i)=='1' || s.charAt(i)=='2')){
    //             b=solve(i+2,s,dp);
    //             if(s.charAt(i)=='1')
    //             b*=9;
    //             else
    //             if(s.charAt(i)=='2')
    //             b*=6;
    //             else
    //             b=0;
    //         }
    //         else{
    //             if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6'))
    //             b=solve(i+2,s,dp);
    //         }
    //     }
    //     return dp[i]=(a+b)%m;
    // }
    // public int numDecodings(String s) {
    //     if(s.charAt(0)=='0')
    //     return 0;

    //     long dp[]=new long[s.length()];
    //     Arrays.fill(dp,-1);
    //     dp[s.length()-1]=1;
    //     if(s.charAt(s.length()-1)=='*')
    //     dp[s.length()-1]=9;
    //     return (int)(solve(0,s,dp)%m);
    // }

    //-------------------------------------------------------------------------------
    //DP
    
    public int numDecodings(String s) {
        int mod = 1000000007;
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '*') ? 9 : (s.charAt(0) == '0' ? 0 : 1);
        for(int i=1;i<s.length();++i){
            if(s.charAt(i) == '*'){
                dp[i+1] = 9 * dp[i] % mod;
                if(s.charAt(i-1) == '1')
                    dp[i+1] = (dp[i+1] + 9 * dp[i-1]) % mod;
                else if(s.charAt(i-1) == '2')
                    dp[i+1] = (dp[i+1] + 6 * dp[i-1]) % mod;
                else if(s.charAt(i-1) == '*')
                    dp[i+1] = (dp[i+1] + 15 * dp[i-1]) % mod;
            }
            else{
                dp[i+1] = s.charAt(i) != '0' ? dp[i] : 0;
                if(s.charAt(i-1) == '1')
                    dp[i+1] = (dp[i+1] + dp[i-1]) % mod;
                else if(s.charAt(i-1) == '2' && s.charAt(i) <= '6')
                    dp[i+1] = (dp[i+1] + dp[i-1]) % mod;
                else if(s.charAt(i-1) == '*')
                    dp[i+1] = (dp[i+1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i-1]) % mod;
            }
        }
        return (int)dp[s.length()];
    }
    
}
