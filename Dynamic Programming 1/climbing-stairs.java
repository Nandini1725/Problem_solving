class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] arr = new int[n+1];
        int i=0;
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        
        for(i=3;i<arr.length;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
    
