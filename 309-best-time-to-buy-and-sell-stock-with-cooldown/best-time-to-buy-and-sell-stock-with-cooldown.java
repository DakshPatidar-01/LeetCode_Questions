class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)return 0;
        int dp[][] = new int[5001][2];
        for(int e[]:dp){
            Arrays.fill(e, -1);
        }
        return solve(0,1,prices,dp);
    }

    private int solve(int idx,int buy,int prices[],int dp[][]){
        if(idx>=prices.length)return 0;
        if(dp[idx][buy]!=-1)return dp[idx][buy];
        if(buy==1){
            return dp[idx][buy]=Math.max(
                -prices[idx] + solve(idx+1, 0, prices,dp) ,
                0+ solve(idx+1, buy, prices,dp)
            );
        }
        return dp[idx][buy]=Math.max(prices[idx]+solve(idx+2, 1, prices,dp), 0+solve(idx+1, 0, prices,dp));
    }
}