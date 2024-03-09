class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int low=0,high=n-1;
        while(high>=low){
            int mid=low+((high-low)/2);
            if((mid==0 && nums[mid+1]!=nums[mid]) || (mid==n-1 && nums[mid-1]!=nums[mid]) || (nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]))
            return nums[mid];
  
            
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]) 
                low = mid+2;
                else if(nums[mid]==nums[mid-1])
                high = mid-2;
            }
            else if(mid%2==1){
                if(nums[mid]==nums[mid-1]) 
                low = mid+1;
                else if(nums[mid]==nums[mid+1])
                high = mid-1;
            }
        }
        return -1;
  
    }
}
