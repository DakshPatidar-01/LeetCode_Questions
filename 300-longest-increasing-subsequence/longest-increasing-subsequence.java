class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][]= new int[nums.length][nums.length+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(0, -1, nums,dp);
    }

    private int solve(int idx,int prev,int nums[],int[][] dp){
        if(idx==nums.length)return 0;
        if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];
        int skip=solve(idx+1, prev, nums,dp);
        int take=0;
        if(prev==-1 || nums[idx]>nums[prev])take=1+solve(idx+1, idx, nums,dp);
        return dp[idx][prev+1]=Math.max(take, skip);
    }
}