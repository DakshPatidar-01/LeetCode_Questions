class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length,m=obstacleGrid[0].length;
        if(obstacleGrid[n-1][m-1]==1)return 0;
        int dp[][] = new int[n][m];
        for(int e[]:dp)Arrays.fill(e,-1);
        return solve(0,0,n,m,obstacleGrid,dp);
    }

    private int solve(int i,int j,int n,int m,int[][] obstacleGrid,int[][] dp){
        if(i<0||j<0||i>=n||j>=m||obstacleGrid[i][j]==1)return 0;
        if(i==n-1 && j==m-1) return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int down = solve(i+1 , j, n, m, obstacleGrid,dp);
        int right = solve(i, j+1, n, m, obstacleGrid,dp);
        return dp[i][j]=right+down;
    }
}