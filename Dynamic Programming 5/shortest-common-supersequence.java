class Solution {
    public String solve(String s1, String s2, int m, int n, int[][] dp){
        
        int i=m,j=n;
        String s="";
        
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                s=s1.charAt(i-1)+s;
                i--;
                j--;
            }
            else{
                if(dp[i][j-1]>dp[i-1][j]){
                    s=s2.charAt(j-1)+s;
                    j--;
                }
                else{
                    s=s1.charAt(i-1)+s;
                    i--;
                }
            }
        }
        
        while(i>0){
            s=s1.charAt(i-1)+s;
            i--;
        }
        
        while(j>0){
            s=s2.charAt(j-1)+s;
            j--;
        }
        return s;
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int m =str1.length();
        int n =str2.length();       
        int[][] t=new int[m+1][n+1];

        for(int k=0;k<m+1;k++)
        t[k][0]=0;

        for(int u=0;u<n+1;u++)
        t[0][u]=0;

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                t[i][j] = 1+t[i-1][j-1];
                else
                t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
            }
        }
        return solve(str1,str2,m,n,t);
    }
}
