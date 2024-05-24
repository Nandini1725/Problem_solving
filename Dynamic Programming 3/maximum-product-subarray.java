class Solution {
    //Bottom Up 
    // public int maxProduct(int[] nums) {
    //     int[] max = new int[nums.length];
    //     int[] min = new int[nums.length];
    //     max[0] = Math.max(nums[0], 1);
    //     min[0] = Math.min(nums[0], 1);
        
    //     int maxProduct = nums[0];
        
    //     for(int i=1; i<nums.length;i++) { 
    //         min[i] = Math.min(nums[i],Math.min(nums[i]*min[i-1], nums[i]*max[i-1]));
    //         max[i] = Math.max(nums[i],Math.max(nums[i]*min[i-1], nums[i] *max[i-1]));
            
    //         maxProduct = Math.max(maxProduct,max[i]);
    //     }
    //     return maxProduct;
    // }

    //---------------------------------------------------
    // optimized code
    public int maxProduct(int[] nums) {
        int max=1;
        int min=1;
        int ans = Integer.MIN_VALUE;
        for(int i : nums){
            int temp = max*i;
            max = Math.max(i,Math.max(min*i, temp));
            min = Math.min(i,Math.min(min*i, temp));
            ans = Math.max(ans,max);
        }
        return ans;
    }
}
