class solution
{
    static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
         
        return gcd(b % a, a); 
    } 
 
    static int lcm(int a, int b) 
    { 
        return (a * b) / gcd(a, b); 
    } 
    static int count(int a, int b, int c, int num) 
    {
        return ((num / a) + (num / b) + (num / c) 
                - (num / lcm(a, b)) 
                - (num / lcm(b, c)) 
                - (num / lcm(a, c)) 
                + (num / lcm(a, lcm(b, c)))); 
    }
    static int findNthTerm(int a, int b, int c, int n) 
    { 
        int low = 1, high = Integer.MAX_VALUE, mid; 
 
        while (low < high) { 
            mid = low + (high - low) / 2; 
            if (count(a, b, c, mid) < n) 
                low = mid + 1; 
      
            else
                high = mid; 
        } 
 
        return low; 
    } 
}
