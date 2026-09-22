class Solution {
    int ans=0;
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean [][] visted = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&& !visted[i][j]){
                    checkLand(i, j, grid, visted);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void checkLand(int i,int j,char grid[][],boolean visted[][]){
        if(i<0 || i>=grid.length || j<0|| j>=grid[0].length || grid[i][j]=='0')return;
        if(visted[i][j])return;
        visted[i][j]=true;
        checkLand(i+1, j, grid, visted);
        checkLand(i-1, j, grid, visted);
        checkLand(i, j+1, grid, visted);
        checkLand(i, j-1, grid, visted);
    }
}