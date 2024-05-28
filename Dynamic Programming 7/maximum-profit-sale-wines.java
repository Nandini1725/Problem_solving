import java.util.*;
class Main {
    static final int N = 1000;
    static int[][] dp = new int[N][N];
    static int[][] sell = new int[N][N];
    public static void main(String args[]) {
        int price[] = {3, 1, 6, 7, 5};
        int n = price.length;
        int ans = maxProfit(price, n);
        System.out.println(ans);
    }
    static int maxProfit(int price[], int n) {
        for (int i = 0; i < n; i++) {
            dp[i][i] = n * price[i];
            sell[i][i] = 0;
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                int year = n - (j - i);
                int x = price[i] * year + dp[i+1][j];
                int y = price[j] * year + dp[i][j-1];
                if (x >= y) {
                    dp[i][j] = x;  
                    sell[i][j] = 0;  
                } 
                else {
                    dp[i][j] = y;  
                    sell[i][j] = 1;  
                }
            }
        }
 
        int i = 0, j = n - 1;
        while (i <= j) {
            if (sell[i][j] == 0) {
                System.out.print("beg");
                i++;
            } 
            else {
                System.out.print("end");
                j--;
            }
        }
        System.out.println();
        return dp[0][n - 1]; 
    }

}
