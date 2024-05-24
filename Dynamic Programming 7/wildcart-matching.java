class Solution {
    //Recursion
    // public boolean isMatching(String s, String p, int i, int j){
    //     if(i==s.length() && j==p.length()) return true;
    //     if(i==s.length())
    //     return p.charAt(j)=='*' && isMatching(s,p,i,j+1);

    //     if(j==p.length())
    //     return false;

    //     if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') 
    //     return isMatching(s,p,i+1,j+1);

    //     else if(p.charAt(j)=='*'){
    //         return isMatching(s,p,i+1,j) || isMatching(s,p,i,j+1);
    //     }
    //     else
    //     return false;
    // }
    // public boolean isMatch(String s, String p) {
    //     return isMatching(s,p,0,0);
    // }

    //----------------------------------------------------------------------------
    //Memoization

    // public boolean isMatching(String s, String p, int i, int j,boolean[][] memo){
    //     if(i==s.length() && j==p.length()) return true;
    //     if(i==s.length()){
    //         if(p.charAt(j)=='*')
    //         return isMatching(s,p,i,j+1,memo);
    //     }
    //     if(j==p.length())
    //     return false;
    //     if(memo[i][j]!=false) return memo[i][j];

    //     if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') 
    //     return isMatching(s,p,i+1,j+1,memo);

    //     else if(p.charAt(j)=='*'){
    //         return isMatching(s,p,i+1,j,memo) || isMatching(s,p,i,j+1,memo);
    //     }
    //     else
    //     return memo[i][j]=false;
    // }
    // public boolean isMatch(String s, String p) {
    //     int n=s.length();
    //     int m = p.length();
    //     boolean[][] memo = new boolean[n][m];
    //     return isMatching(s,p,0,0,memo);
    // }

//DP
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                dp[s.length()][i]=true;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                        dp[i][j]=dp[i+1][j+1];
                else if(p.charAt(j)=='*')
                        dp[i][j]=dp[i+1][j]||dp[i][j+1];
                else
                    dp[i][j]=false;
            }
        }
        return dp[0][0];
    }
}
