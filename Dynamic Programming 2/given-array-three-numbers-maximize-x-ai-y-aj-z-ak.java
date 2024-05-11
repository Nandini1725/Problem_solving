class GFG {
    static int maximizeExpr(int a[], int n, int x,  
                             int y, int z) 
    {  
        int[] dp1 = new int[n]; 
        dp1[0] = x*a[0]; 
        for (int i = 1; i < n; i++)  
            dp1[i] = Math.max(dp1[i-1], x*a[i]); 
  
        int[] dp2 = new int[n]; 
        dp2[n-1] = z*a[n - 1]; 
        for (int i = n-2; i>=0; i--) 
            dp2[i] = Math.max(dp2[i+1], z*a[i]); 
  
        int ans = Integer.MIN_VALUE;  
        for (int i= 0; i<n; i++)  
            ans = Math.max(ans,dp1[i] + y*a[i] + dp2[i]);  
        return ans; 
    } 
}
