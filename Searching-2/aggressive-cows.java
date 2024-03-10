class Solution {
    public static boolean canWePlace(int mid, int[] stalls, int k){
        int cowCount=1;
        int last= stalls[0];
        for(int i=0;i<stalls.length;i++){
            if(stalls[i]-last>=mid){
                cowCount++;
                last = stalls[i];
            }
        }
        if(cowCount>=k)
        return true;
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low=1;
        int high=stalls[n-1]-stalls[0];
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(canWePlace(mid,stalls,k)==true){
                ans = mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}
