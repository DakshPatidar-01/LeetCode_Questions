class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo=new int[amount+1];
        Arrays.fill(memo,-2);
        int ans=solve(coins,amount,memo);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int[] coins,int amount,int[] memo) {
        if(amount==0)return 0;
        if(amount<0)return Integer.MAX_VALUE;
        if(memo[amount]!=-2)return memo[amount];
        int ans=Integer.MAX_VALUE;
        for(int coin:coins){
            int next=solve(coins,amount-coin,memo);
            if(next!=Integer.MAX_VALUE)ans=Math.min(ans,1+next);
        }
        return memo[amount]=ans;
    }
}