class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            low = Math.min(low,bloomDay[i]);
            high = Math.max(high,bloomDay[i]);
        }

        while(low<=high){
            int temp=0;
            int count=0;
            int mid = low + ((high-low)/2);
            for(int i=0;i<n;i++){
                if(mid>=bloomDay[i]){
                    count+=1;
                }
                else{
                    temp += count/k;
                    count=0;
                }
            }
            temp += count/k;

            if(temp>=m){
                ans = Math.min(ans,mid);
                high = mid-1;
            }
            else{
                low= mid+1;
            }
            
        }
        if(ans==Integer.MAX_VALUE)
        return -1;
        return ans;
    }
}
