class Solution {
    public int climbStairs(int n) {
        if(n<=3)return n;
        int memo[] = new int[n+1];
        Arrays.fill(memo, -1);
        for(int i=0;i<4;i++)memo[i]=i;
        return solve(n,memo);
    }

    private int solve(int n,int[] memo){
        if(memo[n]!=-1)return memo[n];
        return memo[n]=solve(n-1, memo)+solve(n-2, memo);
    }
}