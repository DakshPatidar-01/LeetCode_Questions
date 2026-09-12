class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]!=0){
                    maxGold=Math.max(maxGold,findMax(i,j,grid));
                }
            }
        }
        return maxGold;
    }

    private int findMax(int i,int j,int[][] grid){
        if(i<0 || i>=grid.length ||
           j<0 || j>=grid[0].length ||
           grid[i][j]==0){
            return 0;
        }
        int gold=grid[i][j];
        grid[i][j]=0;
        int up=findMax(i-1,j,grid);
        int down=findMax(i+1,j,grid);
        int left=findMax(i,j-1,grid);
        int right=findMax(i,j+1,grid);
        grid[i][j]=gold;
        return gold+Math.max(
            Math.max(up,down),
            Math.max(left,right)
        );
    }
}