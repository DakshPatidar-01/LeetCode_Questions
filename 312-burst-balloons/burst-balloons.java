class Solution {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Boundary me 1 add kar diya
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++)arr[i + 1] = nums[i];
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp)java.util.Arrays.fill(row, -1);
        return solve(arr, 1, n, dp);
    }

    private int solve(int[] arr, int left, int right, int[][] dp) {
        if (left > right)return 0;
        if (dp[left][right] != -1)return dp[left][right];
        int ans = 0;
        // Har balloon ko last burst maan kar try karo
        for (int k = left; k <= right; k++) {
            int coins = arr[left - 1] * arr[k] * arr[right + 1];
            int leftPart = solve(arr, left, k - 1, dp);
            int rightPart = solve(arr, k + 1, right, dp);
            ans = Math.max(ans, coins + leftPart + rightPart);
        }
        return dp[left][right] = ans;
    }
}