class Solution {
    public int numSquares(int n) {
        List<Integer> squares=new ArrayList<>();
        for(int i=1;i*i<=n;i++)squares.add(i*i);
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int ps:squares){
                if(ps>i)break;
                if(dp[i-ps]!=Integer.MAX_VALUE)
                    dp[i]=Math.min(dp[i],1+dp[i-ps]);
            }
        }
        return dp[n];
    }
}