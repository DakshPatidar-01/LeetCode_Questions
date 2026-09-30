class Solution {
    public static int fib(int n) {
        if(n<=1)return n;
        int memo[] = new int[n+1];
        Arrays.fill(memo, -1);
        memo[0]=0;memo[1]=1;
       return solve(n,memo);
    }

    private static int solve(int n,int[] memo){
        if(memo[n]!=-1)return memo[n];
        return memo[n]=solve(n-1, memo)+solve(n-2, memo);
    }
}