class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{solve(nums,target,"first"),solve(nums,target,"second")};
    }

    public int solve(int[] nums, int target, String find){
        int n = nums.length;
        int start=0;
        int end = n-1;
        int res=-1;
        while(start<=end){
            int mid = start + ((end-start)/2);
            if(nums[mid]==target){
                res=mid;
                if(find=="first")
                end = mid-1;
                else
                start=mid+1;
            }
            else if(nums[mid]>target)
            end=mid-1;
            else
            start=mid+1;
        }
        return res;
    }
}
