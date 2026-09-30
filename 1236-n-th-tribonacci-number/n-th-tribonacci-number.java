class Solution {
    public int tribonacci(int n) {
        if(n<=1)return n;
        if(n==2)return 1;
        int memo[]=new int[n+1];
        Arrays.fill(memo, -1);
        memo[0]=0;memo[1]=1;memo[2]=1;
        return solve(n,memo);
    }

    private int solve(int n,int[] memo){
        if(memo[n]!=-1)return memo[n];
        return memo[n]=solve(n-1, memo)+solve(n-2, memo)+solve(n-3, memo);
    }
}