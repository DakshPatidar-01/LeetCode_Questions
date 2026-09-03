class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currmax=nums[0],max=nums[0],min=nums[0],total=nums[0],curmin=nums[0];
        for(int i=1;i<nums.length;i++){
            currmax = Math.max(nums[i],currmax+nums[i]);
            max=Math.max(currmax,max);
            curmin=Math.min(nums[i],curmin+nums[i]);
            min=Math.min(curmin, min);
            total+=nums[i];
        }

        if(max<0)return max;
        return Math.max(max, total-min);
    }
}