class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    checkLand(i,j,grid);
                    ans++;
                }
            }
        }
        return ans;
    }


    private void checkLand(int i,int j,char grid[][]){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0')return;
        if(grid[i][j]=='@')return;
        grid[i][j]='@';
        checkLand(i+1, j, grid);
        checkLand(i-1, j, grid);
        checkLand(i, j+1, grid);
        checkLand(i, j-1, grid);
    }
}