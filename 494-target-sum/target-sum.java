class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0,0,nums,target);
    }

    private int solve(int idx,int currSum,int[] nums,int target){
        if(idx==nums.length)return currSum==target?1:0;
        int plus = solve(idx+1, currSum+nums[idx], nums, target);
        int minus = solve(idx+1, currSum-nums[idx], nums, target);
        return plus+minus;
    }
}