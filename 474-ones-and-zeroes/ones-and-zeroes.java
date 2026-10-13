class Solution {
    int[][][] memo;
    public int findMaxForm(String[] strs,int m,int n) {
        memo=new int[strs.length][m+1][n+1];
        for(int[][] a:memo)for(int[] b:a)Arrays.fill(b,-1);
        return solve(0,0,0,m,n,strs);
    }

    private int solve(int idx,int curr0,int curr1,int m,int n,String[] strs) {
        if(idx==strs.length)return 0;
        if(memo[idx][curr0][curr1]!=-1)return memo[idx][curr0][curr1];
        int skip=solve(idx+1,curr0,curr1,m,n,strs);
        int zeros=0,ones=0;
        for(char c:strs[idx].toCharArray()){
            if(c=='0')zeros++;
            else ones++;
        }
        int take=0;
        if(curr0+zeros<=m && curr1+ones<=n)take=1+solve(idx+1,curr0+zeros,curr1+ones,m,n,strs);
        return memo[idx][curr0][curr1]=Math.max(take,skip);
    }
}