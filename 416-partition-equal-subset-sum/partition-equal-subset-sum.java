class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int x : nums)totalSum += x;
        if (totalSum % 2 != 0) return false;
        int targetSum = totalSum / 2;
        Boolean[][] dp = new Boolean[nums.length][targetSum + 1];
        return solve(nums, 0, targetSum, dp);
    }

    private static boolean solve(int[] nums, int idx, int targetSum, Boolean[][] dp) {
        if (targetSum == 0) return true;
        if (idx == nums.length || targetSum < 0) return false;
        if (dp[idx][targetSum] != null) return dp[idx][targetSum];
        dp[idx][targetSum] =solve(nums, idx + 1, targetSum, dp) || solve(nums, idx + 1, targetSum - nums[idx], dp);
        return dp[idx][targetSum];
    }
}