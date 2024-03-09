class Solution {
    public int findPeakElement(int[] nums) {
        int n =nums.length;
        int low =0;
        int high = n-1;

        if(low==high)
        return low;
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(mid>0 && mid<n-1){
                if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                return mid;

                else if(nums[mid-1]>nums[mid])
                high=mid-1;

                else
                low=mid+1;
            }
            else if(mid==0){
                if(nums[0]>nums[1])
                return 0;
                else
                return 1;
            }

            else if(mid==n-1){
                if(nums[n-1]>nums[n-2])
                return n-1;
                else
                return n-2;
            }
        }
        return -1;
    }
}
