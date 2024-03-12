class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low=1;
        int high = 0;

        for(int i=0;i<nums.length;i++){
            high = Math.max(high,nums[i]);
        }

        while(low<high){
            int mid= (low+high)/2;

            int cnt=0;
            for(int i=0;i<nums.length;i++){
                cnt+= (nums[i]-1)/mid;
            }

            if(cnt<=maxOperations){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
