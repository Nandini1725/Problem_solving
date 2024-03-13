
class Solution
{
    public static int solve(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }
    public int NthRoot(int n, int m)
    {
        
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int x = solve(mid, n, m);
            if (x == 1) {
                return mid;
            } else if (x == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
